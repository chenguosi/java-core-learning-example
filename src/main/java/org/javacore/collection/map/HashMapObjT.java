package org.javacore.collection.map;

import java.util.HashMap;

/**
 * Created by Guosi Chen on 2017/4/19.
 * HashMap 操作对象的决定因子：hashCode与equals
 */
public class HashMapObjT {
    public static void main(String[] args) {
        HashMap<A,Integer> hashMapA = new HashMap<>();
        hashMapA.put(new A(),10);
        hashMapA.put(new A(),5);
        System.out.println("HashMapA Elements: ");
        System.out.print("\t" + hashMapA + "\n");

        HashMap<B,Integer> hashMapB = new HashMap<>();
        hashMapB.put(new B(),10);
        hashMapB.put(new B(),5);
        System.out.println("HashMapB Elements: ");
        System.out.print("\t" + hashMapB + "\n");

        HashMap<C, Integer> hashMapC = new HashMap<>();
        hashMapC.put(new C(), 10);
        hashMapC.put(new C(), 5);
        System.out.println("HashMapC Elements:");
        System.out.print("\t" + hashMapC + "\n");
    }
}

class A {
    public boolean equals(Object o) {
        return true;
    }
}

class B {
    public int hashCode() {
        return 1;
    }
}

class C {
    public int hashCode() {
        return 2;
    }

    public boolean equals(Object o){
        return true;
    }
}
