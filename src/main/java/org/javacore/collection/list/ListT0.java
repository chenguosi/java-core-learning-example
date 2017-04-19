package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 打印list 全部元素，并找到其中元素aaa删除。要求：所有元素都遍历完
 * ListIterator 的使用
 * list那个remove回抛异常是因为快速失败的机制，
 * 他内置了一个modifyCount的变量记录list的长度变化，用Iter可以删除掉
 */
public class ListT0 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("aaa");
        list.add("6");
        list.add("7");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Object o = listIterator.next();
            System.out.println(o);
            if("aaa".equals(o)){
                listIterator.remove();
            }
        }
    }

}
