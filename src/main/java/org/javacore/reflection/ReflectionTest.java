package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 反射对象构造函数、方法及字段
 */
public class ReflectionTest {

    /**
     * 打印Class对象的构造函数
     * @param cl
     */
    public static void printConstructors(Class cl) {
        // 返回类的所有构造函数
        Constructor[] constructors = cl.getConstructors();
        for (Constructor c : constructors) {
            // 返回构造函数的名称
            String name = c.getName();
            System.out.println("    ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifers = Modifier.toString(c.getModifiers());
            if (modifers.length() > 0) {
                System.out.println(modifers + "     ");
            }
            System.out.println(name + "(");

            // 获取构造函数的参数对象列表数组
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.println("    ");
                }
                System.out.println(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印Class对象的所有方法
     * @param cl
     */
    public static void printMethods(Class cl) {
        // 获取类所有方法对象数组
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            // 获取方法返回对象
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.println("    ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + "    ");
            }
            System.out.println(retType.getName() + "    " + name + "(");

            // 获取方法的参数对象列表数组
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.println(",   ");
                }
                System.out.println(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class clazz) {
        // 获取字段Field对象数组
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            // 获取字段声明类型对象
            Class type = field.getType();
            // 获取字段名称
            String name = field.getName();

            System.out.println("    ");
            // 获取Java语言的修饰符
            // 修饰符由 Java 虚拟机的 public、protected、private、
            // final、static、abstract 和 interface 对应的常量组成；
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + "    ");
            }
            System.out.println(type.getName() + "   " + name);
        }
    }

    public static void main(String[] args) {
        Class cl;
        try {
            cl = Class.forName("org.javacore.reflection.ReflectionTest");
            System.out.println("------打印构造函数-------");
            printConstructors(cl);
            System.out.println("-------打印方法-------");
            printMethods(cl);
            System.out.println("-----打印字段-----");
            printFields(cl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
