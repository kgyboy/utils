package com.kgyboy.utils;

import java.util.UUID;

public class UuidUtils {

    public static String getInstance(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
