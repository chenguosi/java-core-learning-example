package org.javacore.base.string;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 对象含有String作为方法参数传递
 */
public class StringT2 {

    public static StringObject change(StringObject object) {
        object = new StringObject();
        object.setName("456");
        System.out.println(object.getName());
        return object;
    }

    public static void main(String[] args) {
        StringObject object = new StringObject();
        object.setName("123");
        change(object);
        System.out.println(object.getName());
    }
}

class StringObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
