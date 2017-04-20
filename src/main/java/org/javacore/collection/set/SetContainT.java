package org.javacore.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Guosi Chen on 2017/4/20.
 */
public class SetContainT {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 2, 5));
        System.out.println(getUnion(s1, s2));

    }

    /**
     * 获取Set中不同对象的个数
     * @param s1
     * @param s2
     * @return
     */
    public static int getUnion(Set<?> s1, Set<?> s2) {
        int count = s1.size();
        for (Object obj : s2) {
            if (!s1.contains(obj)) {
                count++;
            }
        }
        return count;
    }
}
