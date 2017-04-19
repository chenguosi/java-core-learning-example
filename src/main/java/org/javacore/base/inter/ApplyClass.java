package org.javacore.base.inter;

import java.util.Arrays;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 不使用接口的案例
 */

class Processor {

    public String name() {
        return this.getClass().getName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Splitcase extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyClass {
    public static void process(Processor processor,Object input){
        System.out.println("调用对象名：" + processor.name());
        System.out.println(processor.process(input));
    }
    public static String s = "GusChan's email is chenguosi@qq.com";

    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Splitcase(),s);
    }
}
