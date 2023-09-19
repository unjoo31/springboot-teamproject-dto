package com.example.kakao.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao.user.User;

@DataJpaTest
public class OrderJPARepositoryTest {

    @Autowired
    private OrderJPARepository orderJPARepository;

    @Test
    public void findByOrderIdAndUserId_test() {

        Order order = orderJPARepository.findByOrderIdAndUserId(1, 1).get();
        System.out.println("오더 : " + order.getId() + " " + order.getUser().getId());
    }
}
