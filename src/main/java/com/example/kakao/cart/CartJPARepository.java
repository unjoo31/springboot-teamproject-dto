package com.example.kakao.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserId(Integer userId);

    void deleteByUserId(int userId);

    List<Cart> findAllByUser(int id);
}
