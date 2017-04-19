package org.javacore.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guosi Chen on 2017/4/19.
 * HashMap的Add方法
 */
public class HashMapT {

    public static void main(String[] args) {
        objOper();
        nullOper();
    }

    /**
     * HaspMap操作对象方法
     */
    public static void objOper() {
        // ConcurrentMap<String,Employee> employees = new ConcurrentHashMap<>();
        Map<String, Employee> employees = new HashMap<>();

        String number = "20170419";

        // 设置对象
        employees.put(number, new Employee());
        System.out.println(employees);

        // 获取对象
        System.out.println(employees.get(number));
    }

    /**
     * HaspMap的put方法
     */
    public static void nullOper() {
        //ConcurrentHashMap的key不能为null
        // ConcurrentMap<String,String> map = new ConcurrentHashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put(null, "null01");
        map.put(null, "null02");
        System.out.println(map);
        System.out.println(map.get(null));
    }
}

class Employee {

}
