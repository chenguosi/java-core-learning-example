package org.javacore.base.copy;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 深拷贝与浅拷贝
 */

class Family implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     */
    @Override
    protected Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

class Student implements Cloneable {
    private String name;

    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     */
    /*@Override
    protected Object clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student.family = (Family) family.clone();
        return student;
    }*/
}

public class CopyT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("GusChan Family");
        Student student1 = new Student();
        student1.setName("GusChan");
        student1.setFamily(family);

        Student student2 = (Student) student1.clone();
        student2.setName("Tom");
        student2.getFamily().setName("Tom Family");

        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());
    }
}
