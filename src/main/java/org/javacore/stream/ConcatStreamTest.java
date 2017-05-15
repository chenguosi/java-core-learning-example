package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 拼接数组
 */
public class ConcatStreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");

        // 组合list1和list2的流
        List result = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }
}
