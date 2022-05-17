package com.example.unifiedplatform.utils;

import java.util.Random;

public class RandomUtil {
    public static synchronized String newCaptcha(int len){
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }
}
