package com.example.kakao.core;

import org.junit.jupiter.api.Test;

public class EnvTest {

    // Java 환경변수 확인하는 방법
    @Test
    public void env_test1() {
        String home = System.getenv("JAVA_HOME");
        System.out.println(home);
    }

    @Test
    public void env_test2() {
        String home = System.getProperty("FILE_PATH");
        System.out.println(home);
    }
}
