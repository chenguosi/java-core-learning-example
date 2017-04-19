package org.javacore.colgoogle;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;

/**
 * Created by Guosi Chen on 2017/4/19.
 */
public class MapMakerT {
    // 使用案例:存储验证码
    // <String, String> == <用户唯一，验证码>
    // expiration(15, TimeUnit.MINUTES) 有效期15分钟
    ConcurrentMap<String,String> capthcaMap = new MapMaker().expiration(15, TimeUnit.MINUTES).makeMap();

    // 设置ConcurrentMap的concurrencyLevel参数 ，例如ConcurrentHashMap是用来控制其Segment数组的大小
    ConcurrentMap<String,String> map1 = new MapMaker().concurrencyLevel(8).makeMap();

    // 构造各种不同reference作为key和value的map
    ConcurrentMap<String,String> map2 = new MapMaker().softKeys().weakValues().makeMap();

    // 提供当Map里面不包含所get的项，可以自动加入到Map的功能
    ConcurrentMap<String,Integer> map3 = new MapMaker().makeComputingMap(
            new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return 1;
                }
            }
    );
}
