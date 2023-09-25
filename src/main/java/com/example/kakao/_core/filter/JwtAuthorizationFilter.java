package com.example.kakao._core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.kakao._core.errors.exception.Exception401;
import com.example.kakao._core.utils.ApiUtils;
import com.example.kakao._core.utils.JwtTokenUtils;
import com.example.kakao._core.utils.ApiUtils.ApiResult;
import com.example.kakao.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * /carts/**
 * /orders/**
 * /products/**
 * 이 주소만 필터가 동작하면 된다
 */
public class JwtAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 토큰 있는지 확인
        String jwt = request.getHeader("Authorization");
        if (jwt == null || jwt.isEmpty()) {
            onError(response, "토큰이 없습니다");
            return; // 더 이상 코드 내려가지마
        }

        // 토큰이 있을때 세션을 만들어준다.
        try {
            DecodedJWT decodedJWT = JwtTokenUtils.verify(jwt);
            int userId = decodedJWT.getClaim("id").asInt();
            String email = decodedJWT.getClaim("email").asString();

            // 컨트롤러에서 꺼내쓰기 쉽게 하려고 세션을 만든다. (안하면 2번 검증)
            User sessionUser = User.builder().id(userId).email(email).build();

            HttpSession session = request.getSession();
            session.setAttribute("sessionUser", sessionUser);
            chain.doFilter(request, response); // 다음 필터를 타라
        } catch (SignatureVerificationException | JWTDecodeException e1) {
            onError(response, "토큰 검증 실패"); // 검증실패
        } catch (TokenExpiredException e2) {
            onError(response, "토큰 시간 만료");
        }
        // 토큰 검증

    }

    // ExceptionHandler를 호출할 수 없다. 왜? Filter니까! DS전에 작동하니까 !!
    private void onError(HttpServletResponse response, String msg) {
        Exception401 e401 = new Exception401(msg);

        try {
            String body = new ObjectMapper().writeValueAsString(e401.body()); // 객체를 직접 json문자로 바꿈
            response.setStatus(e401.status().value()); // 숫자가 401이 들어감
            // response.setHeader("Content-Type", "application/json; charset=utf-8");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 마임타입을 알려준다.
            PrintWriter out = response.getWriter(); // 응답의 버퍼에 연결한다.
            out.println(body); // 서버에 json데이터를 써줌
        } catch (Exception e) {
            System.out.println("파싱 에러가 날 수 없음");
        }
    }
}