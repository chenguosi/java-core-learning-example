package org.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 计算数组平均值*2的结果
 */
public class CollectStreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.averagingDouble(value -> value * 2));
        System.out.println(result);
    }
}
