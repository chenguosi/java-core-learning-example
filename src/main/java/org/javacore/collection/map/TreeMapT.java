package org.javacore.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Guosi Chen on 2017/4/19.
 * TreeMap 的使用
 */
public class TreeMapT {
    public static void main(String[] args) {
        // ConcurrentMap<String,String> map = new ConcurrentSkipListMap();
        Map<String,String> map = new TreeMap<>();
        map.put("1", "1");
        map.put("4", "4");
        map.put("2", "2");
        map.put("2", "3");
        // map.put(null,"12"); // ConcurrentSkipListMap的key不能为Null
        // 注意排序
        System.out.println(map);

    }
}
