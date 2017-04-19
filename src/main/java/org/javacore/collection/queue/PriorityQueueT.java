package org.javacore.collection.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Guosi Chen on 2017/4/19.
 * PriorityQueue的使用
 */
public class PriorityQueueT {
    public static void main(String[] args) {
        Integer[] integers = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(integers).forEach(s -> queue.offer(s));
        // 注意排序
        System.out.println(queue);
    }
}
