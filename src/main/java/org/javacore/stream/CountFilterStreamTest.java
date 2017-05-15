package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤
 * 流的元素数量
 * Created by Guosi Chen on 2017/5/15.
 */
public class CountFilterStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "ac");

        // filter 过滤
        List result = list1.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
        result.stream().forEach(System.out::print);
        System.out.println();

        // count 流的元素数量
        long l = list1.stream().filter(str -> str.startsWith("a")).count();
        System.out.println("list1 字符从a开始的数量:" + l);
    }
}
