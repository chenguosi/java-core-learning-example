package org.javacore.collection.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guosi Chen on 2017/4/20.
 * Collections.EMPTY_MAP 与 new HashMap 性能对比
 * 场景：webservice接口，根据某些条件直接返回空Map，则使用Collections.EMPTY_MAP。
 */
public class PerBtwnEmptyMapAndHashMapT {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long endTime;
        long duration;
        for (int i = 0; i < 100000000; i++) {
            Map map = Collections.EMPTY_MAP;
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Collections.EMPTY_MAP:  " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000000; i++) {
            Map map = new HashMap<>();
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("new HashMap:  " + duration);
    }

}
