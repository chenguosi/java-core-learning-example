package org.javacore.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Guosi Chen on 2017/5/15.
 * Stream API 集合的流式操作
 */
public class CollectionStreamTest01 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a1", "a2", "c3", "c6", "c4");
        strList.stream().filter(str -> str.startsWith("c")).map(String::toUpperCase).sorted()
                .forEach(System.out::println);
    }
}
