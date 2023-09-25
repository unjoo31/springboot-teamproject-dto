package com.example.kakao._core.utils;

import java.time.Instant;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.kakao.user.User;

public class JwtTokenUtils {

    public static String create(User user) {
        String jwt = JWT.create()
                .withSubject("metacoding-key") // 토큰의 이름 꼭 필요함(중요 x)
                .withClaim("id", user.getId()) // 프라이머리 키를 넣어준다. (인증에 필요한 것)
                .withClaim("email", user.getEmail())
                .withExpiresAt(Instant.now().plusMillis(1000)) // 토큰의 만료시간 (엄청 중요)
                .sign(Algorithm.HMAC512("meta"));
        return "Bearer " + jwt;
    }

    public static DecodedJWT verify(String jwt)
            throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", ""); // 토큰으로 인증하는 방식을 베리어 인증방식인대

        // JWT를 검증한 후, 검증이 완료되면, headerm payload를 base64로 복호화함.
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("meta"))
                .build().verify(jwt); // 디코딩 해서 넣어주는 라이브러리
        return decodedJWT; // 헤더랑 페이로드가 디코드 됨.
    }

}
