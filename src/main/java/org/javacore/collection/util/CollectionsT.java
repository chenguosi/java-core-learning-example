package org.javacore.collection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guosi Chen on 2017/4/20.
 * Collections的使用
 */
public class CollectionsT {

    public static void main(String[] args) {
        testSort();
        testAddAll();
    }

    /**
     * 测试集合工具类Sort方法
     */
    public static void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        // 调用集合工具类Sort方法
        Collections.sort(list);

        System.out.println("list sorted:");
        System.out.print("\t" + list + "\n");
    }

    public static void testAddAll() {
        List<String> list = new ArrayList<>();
        list.add("s2");
        list.add("s4");
        list.add("s1");
        list.add("s3");
        System.out.println(list);
        Collections.addAll(list, "s5", "s7", null, "s9");
        System.out.println(list);
    }
}
