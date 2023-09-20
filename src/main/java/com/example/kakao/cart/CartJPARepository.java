package com.example.kakao.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakao.order.OrderResponse.FindAllByUserDTO.CartDTO;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserId(int userId);

    void deleteByUserId(int userId);

    List<Cart> findAllByUser(int id);

}
