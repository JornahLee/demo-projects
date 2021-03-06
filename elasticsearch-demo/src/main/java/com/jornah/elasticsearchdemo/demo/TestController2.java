package com.jornah.elasticsearchdemo.demo;

import com.jornah.elasticsearchdemo.pojo.Person;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchPhraseQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;

@RestController
@RequestMapping("/v2")
public class TestController2 {

    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public TestController2(ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @PostMapping("/person")
    public String save(@RequestBody Person person) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId().toString())
                .withObject(person)
                .build();
        String documentId = elasticsearchRestTemplate.index(indexQuery);
        return documentId;
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id") Long id) {
        Person person = elasticsearchRestTemplate
                .queryForObject(GetQuery.getById(id.toString()), Person.class);
        return person;
    }

    @GetMapping("/person/findByKeyword")
    public List<Person> findByKeyword(String keyword) {
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("lastname").descending());
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("firstname", keyword))
                .withPageable(pageRequest)
                .build();
        List<Person> people = elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
        people.forEach(System.out::println);
        return people;
    }

    @GetMapping("/person/find/all")
    public List<Person> findAll() {
        PageRequest pageRequest = PageRequest.of(0, 200);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withPageable(pageRequest)
                .build();
        return elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
    }

    // filter ???query ????????????
    // query?????????i??????????????????????????????????????????????????????????????????????????????
    // ???filter????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
    // ????????????????????????????????????
    // ???????????????filter?????????????????????
    //         1.?????????????????????
    // 2.??????????????????
    public Object findByFilter() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(
                        QueryBuilders.boolQuery()
                                .must(matchQuery("price", 80))  //????????????.bool -> must ->match
                                // ?????????????????????
                                .filter(rangeQuery("price").gt(6))
                )

                .build();
        return elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
    }
        //????????????
    public Object findByPhrase() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(
                        matchPhraseQuery("name","heiren")
                )
                .build();

        return elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
    }
    public Object findWithHighlight() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(
                        matchPhraseQuery("name", "heiren")
                )
                .withHighlightFields(new HighlightBuilder.Field("name"))
                .build();
        return elasticsearchRestTemplate.queryForList(searchQuery, Person.class);
    }

    // https://blog.csdn.net/mj86534210/article/details/79910909 ????????????
}