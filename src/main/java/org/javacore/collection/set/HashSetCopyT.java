package org.javacore.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Guosi Chen on 2017/4/20.
 * HashSet及其子类的转换使用
 */
public class HashSetCopyT {

    public static void main(String[] args) {
        Set setOne = new HashSet();
        setOne.add("List");
        setOne.add("Queue");
        setOne.add("Set");
        setOne.add("Map");

        System.out.println("HashSet Elements :");
        System.out.print("\t" + setOne + "\n");

        Set setTwo = copy(setOne);
        System.out.println("HashSet Elements After Copy:");
        System.out.print("\t" + setTwo + "\n");

    }

    public static Set copy(Set set){
        Set setCopy = new LinkedHashSet(set);
        return setCopy;
    }
}
