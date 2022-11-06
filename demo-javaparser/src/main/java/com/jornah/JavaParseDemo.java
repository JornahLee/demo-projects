package com.jornah;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author licong
 * @date 2022/11/6 13:46
 */
public class JavaParseDemo {

    /**
     * 使用JavaParse 解析 java 文件结构 的demo
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // parse() 参数可以是 String, File, InputStream等
        CompilationUnit cu = StaticJavaParser.parse(new File("src/main/java/com/jornah/JavaParseDemo.java"));
        List<MethodDeclaration> mds = cu.findAll(MethodDeclaration.class);
        mds.forEach(md-> System.out.println(md.toString() + "\n------------------------------\n"));
    }


}
