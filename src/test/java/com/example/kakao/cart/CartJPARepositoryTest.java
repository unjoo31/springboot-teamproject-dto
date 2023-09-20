package com.example.kakao.cart;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao.cart.CartResponse.FindAllByUserDTO;

@DataJpaTest
public class CartJPARepositoryTest {

    @Autowired
    private CartJPARepository cartJPARepository;

    @Test
    public void findAllByUserId_test() {

        List<Cart> cartList = cartJPARepository.findAllByUserId(1);
        for (Cart cart : cartList) {
            System.out.println("조회한 값" + cart.getOption().getPrice());
        }

        // List<CartResponse.ProductDTO> productDTOs = cartList.stream()

        ;
        if (!cartList.isEmpty()) {
            Cart cart = cartList.get(0);
            System.out.println("조회한 값" + cart);
        } else {
            System.out.println("오류발생");
        }

    }
}