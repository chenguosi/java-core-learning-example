package org.javacore.reflection;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 反射在继承中的案例
 */

class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }
}

public class EmployeeClass {
    public static void main(String[] args) {
        Employee employee = new Employee("小虎");
        Employee manager = new Manager("小熊");
        System.out.println(employee.getClass().getName() + "    " + employee.getName());
        System.out.println(manager.getClass().getName() + "     " + manager.getName());
    }
}
