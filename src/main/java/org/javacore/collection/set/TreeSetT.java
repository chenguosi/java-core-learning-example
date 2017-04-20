package org.javacore.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Guosi Chen on 2017/4/20.
 * TreeSet操作已实现Comparable接口的对象
 */
public class TreeSetT {
    public static void main(String[] args) {
        TreeSet<Bird> treeSet = new TreeSet<>();
        treeSet.add(new Bird(1));
        treeSet.add(new Bird(3));
        treeSet.add(new Bird(2));
        // 注意排序
        Iterator<Bird> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Bird bird = iterator.next();
            System.out.println(bird);
        }
    }
}

class Bird implements Comparable<Bird> {

    private int size;

    public Bird(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size + "号鸟";
    }

    @Override
    public int compareTo(Bird o) {
        return this.size - o.size;
    }
}
