package com.kgyboy.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * parallelStream().foreach()使用线程安全的
 *
 *
 * @ClassName CollectionUtils
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2020/9/25
 */
public class CollectionUtils {

    /**
     * `1.为什么list的大小不固定？
     *  2.为什么list会有null元素？
     *
     * list扩容时发生的机率高
     *
     * `1.读取数组的长度存入n
     *  2.向这个数组中储入元素arr[n]=a
     *  3.将n+1
     *  4.保存n
     *  而对于parrallelStorage元素数量不固定的原因就是多线程有可能同时读取到相同的下标n同时赋值，这样就会出现元素缺失的问题了
     * @param list1
     * @param list2
     * @return
     */
    public static List intersection(List list1, List list2) {
        List list = Collections.synchronizedList(new ArrayList<>());
        if (list1 != null && list2 != null && !list1.isEmpty() && !list2.isEmpty()) {
            list1.parallelStream().forEach(e -> {
                if (e != null && list2.contains(e)) {
                    list.add(e);
                }
            });
        }
        return list;
    }

    public static List union(List list1, List list2) {
        List list = Collections.synchronizedList(new ArrayList<>());
        if (list1 != null && list2 != null && !list1.isEmpty() && !list2.isEmpty()) {
            list1.parallelStream().forEach(e -> {
                if (!list2.contains(e)) {
                    list.add(e);
                }
            });
            list.addAll(list2);
        }
        return list;
    }
}
