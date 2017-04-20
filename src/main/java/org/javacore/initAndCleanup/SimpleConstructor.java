package org.javacore.initAndCleanup;

/**
 * Created by Guosi Chen on 2017/4/20.
 * 简单构造器的展示
 */
public class SimpleConstructor {

    static {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Child();
        new Child("","");
    }
}

class Child extends Parent {

    private String lastName;

    static {
        System.out.println("Child static A... ");
    }

    public Child() {
        System.out.println("Child init... ");
    }

    public Child(String lastName) {
        this.lastName = lastName;
        System.out.println("Child lastName init... ");
    }

    public Child(String firstName, String lastName) {
        super(firstName);
        this.lastName = lastName;
        System.out.println("Child WHY init... ");
    }

    static {
        System.out.println("Child static B... ");
    }

}

class Parent {

    private String firstName;

    static {
        System.out.println("Parent static A... ");
    }

    public Parent() {
        System.out.println("Parent init... ");
    }

    public Parent(String firstName) {
        this.firstName = firstName;
        System.out.println("Parent firstName init... ");
    }

    static {
        System.out.println("Parent static B... ");
    }

}