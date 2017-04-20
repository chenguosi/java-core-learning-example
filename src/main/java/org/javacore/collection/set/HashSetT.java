package org.javacore.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Guosi Chen on 2017/4/20.
 * HashSet的Add方法
 */
public class HashSetT {
    public static void main(String[] args) {
        Set set1 = new HashSet<String>();
        set1.add("List");
        set1.add(new String("List"));
        set1.add("List");
        set1.add("Set");
        set1.add("Queue");
        set1.add("Map");
        // 注意排序
        System.out.println("HashSet Elements:");
        System.out.print("\t" + set1 + "\n");
    }
}
