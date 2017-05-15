package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序
 * Created by Guosi Chen on 2017/5/15.
 */
public class SortedStreamTest {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "e", "b", "ac");

        // 排序
        List result = list1.stream().sorted().collect(Collectors.toList());
        result.stream().forEach(System.out::print);
    }
}
