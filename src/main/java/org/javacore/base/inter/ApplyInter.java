package org.javacore.base.inter;

import java.util.Arrays;

/**
 * Created by Guosi Chen on 2017/4/19.
 * 使用接口的接口案例
 */
interface ProcessorInter{
    String name();
    Object process(Object input);
}

class UpcaseImpl implements ProcessorInter{

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class SplitcaseImpl implements ProcessorInter{

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}


public class ApplyInter {

    public static void process(ProcessorInter processorInter,Object input){
        System.out.println("调用对象:   " + processorInter.name());
        System.out.println(processorInter.process(input));
    }

    public static String s = "GusChan's email is chenguosi@qq.com";
    public static void main(String[] args) {
        process(new UpcaseImpl(),s);
        process(new SplitcaseImpl(),s);
    }
}
