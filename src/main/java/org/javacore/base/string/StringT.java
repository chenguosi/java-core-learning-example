package org.javacore.base.string;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 常见面试题：String作为方法参数传递,另外一个例子 ${@link StringT2}
 * 这就叫做“值传递”，即方法操作的是参数变量（也就是原型变量的一个值的拷贝）
 * 改变的也只是原型变量的一个拷贝而已，而非变量本身
 */
public class StringT {
    public static String change(String str) {
        str = "456";
        System.out.println(str);
        return str;
    }

    public static Integer show(Integer i) {
        i = 5;
        System.out.println(i);
        return i;
    }

    public static void main(String[] args) {
        String str = "123";
        change(str);
        System.out.println(str);
        Integer i = 10;
        show(i);
        System.out.println(i);
    }
}
