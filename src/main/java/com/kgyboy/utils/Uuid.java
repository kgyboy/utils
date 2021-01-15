package com.kgyboy.utils;

import java.util.UUID;

/**
 *
 * @ClassName Uuid
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2021/1/15
 */
public class Uuid {

    public static String getInstance(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
