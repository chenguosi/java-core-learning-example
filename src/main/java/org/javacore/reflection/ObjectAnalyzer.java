package org.javacore.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by Guosi Chen on 2017/5/15.
 * 反射对象分析工具 @{link test/org.javacore.reflection.ObjectAnalyzerTest}
 */
public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object o) {
        if (o == null) {
            return "null";
        }
        if (visited.contains(o)) {
            return "...";
        }
        visited.add(o);

        // 获取Class对象
        Class aClass = o.getClass();
        if (aClass == String.class) {
            return (String) o;
        }
        // 如果对象是一个数组
        if (aClass.isArray()) {
            // 获取数组组件
            String r = aClass.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i > 0) {
                    r += ",";
                }
                Object val = Array.get(o, i);
                // 是否是一个基本类型
                if (aClass.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";
        }

        String r = aClass.getName();
        do {
            r += "[";
            Field[] fields = aClass.getFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    r += f.getName() + "=";
                    try {
                        Class t = f.getClass();
                        Object val = f.get(o);
                        if (t.isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            aClass = aClass.getSuperclass();
        } while (aClass != null);
        return r;
    }
}
