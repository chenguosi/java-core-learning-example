package org.javacore.collection.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Guosi Chen on 2017/4/20.
 * Iterator与ListIterator的区别
 */
public class IterAndListIterT {
    public static void main(String[] args) {
        // iterator();
        listIterator();
    }

    /**
     * 并发修改异常产生。
     * 原因：Iterator(Object obj = it.next()) 会检查HashMap的size，
     * size发生变化，抛出错误ConcurrentModificationException。
     */
    public static void iterator() {
        List a = new ArrayList<String>();
        a.add("List01");
        a.add("List02");
        a.add("List04");
        a.add("List05");

        Iterator it = a.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if ("List02".equals(o)) {
                a.add("List03");
            }
        }
        System.out.print("集合：\n\t" + a + "\n");
    }

    /**
     * ListIterator可以实现对象的修改。
     */
    public static void listIterator() {
        List a = new ArrayList<String>();
        a.add("List01");
        a.add("List");
        a.add("List03");
        a.add("List04");

        ListIterator iterator = a.listIterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if ("List".equals(o)) {
                // iterator.remove();
                // iterator.add("List02");
                iterator.set("List02");
            }
        }
        System.out.print("集合：\n\t" + a + "\n");
    }

}
