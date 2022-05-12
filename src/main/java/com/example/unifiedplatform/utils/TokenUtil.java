package com.example.unifiedplatform.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.unifiedplatform.entity.User;

public class TokenUtil {

    /**
     * 根据邮箱和密码，生成token
     * @param user
     * @return
     */
    public static String getToken(User user){
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getEmail())).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
