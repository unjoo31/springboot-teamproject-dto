package com.example.kakao.utils;

import org.junit.jupiter.api.Test;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.kakao._core.utils.JwtTokenUtils;
import com.example.kakao.user.User;

public class JwtTokenUtilsTest {

    @Test
    public void jwt_create_and_verify() {
        User user = User.builder().id(1).email("ssar@nate.com").build();
        String jwt = JwtTokenUtils.create(user);
        System.out.println(jwt);
    }

    @Test
    public void jwt_verify_test() {
        String jwt = "";
        DecodedJWT decodedJWT = JwtTokenUtils.verify(jwt);
    }

}
