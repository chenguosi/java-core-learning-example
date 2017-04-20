package org.javacore.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Guosi Chen on 2017/4/20.
 * HashSet 操作对象的决定因子：hashCode与equals
 */
public class HashSetObjT {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new B());
        set.add(new C());
        set.add(new A());
        set.add(new B());
        set.add(new C());
        System.out.println("HashSet Elements:");
        System.out.print("\t" + set + "\n");
    }
}

class A {

    @Override
    public boolean equals(Object o) {
        return true;
    }
}

class B {

    @Override
    public int hashCode() {
        return 1;
    }
}

class C {

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
