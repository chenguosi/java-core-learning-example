package org.javacore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 利用反射通过构造器创建一个实例
 */
public class UserConstructorReflect {

    public static void main(String[] args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取User类型
        Class<?> userClass = User.class;
        // 获取默认构造器
        Constructor<?> constructor = userClass.getConstructor();
        // 获取带int参数的构造器
        Constructor<?> intConstructor = userClass.getConstructor(int.class);
        // 获取带String参数的构造器
        Constructor<?> strConstructor = userClass.getConstructor(String.class);
        // 获取带int和String参数的构造器
        Constructor<?> bothConstructor = userClass.getConstructor(int.class, String.class);

        // 使用反射,获取新的User对象
        User u1 = (User) constructor.newInstance();
        User u2 = (User) intConstructor.newInstance(1);
        User u3 = (User) strConstructor.newInstance("GusChan");
        User u4 = (User) bothConstructor.newInstance(2, "GusChan");

        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(u3.toString());
        System.out.println(u4.toString());
    }
}
