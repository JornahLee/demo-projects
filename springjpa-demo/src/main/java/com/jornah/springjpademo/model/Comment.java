package com.jornah.springjpademo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author licong
 * @date 2022/10/22 18:37
 */
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reply;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    //...
}
