package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 去重
 * Created by Guosi Chen on 2017/5/15.
 */
public class DistinctStreamTest {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "b", "b", "ac");

        // 去重
        List result = list1.stream().distinct().collect(Collectors.toList());
        result.stream().forEach(System.out::print);
    }
}
