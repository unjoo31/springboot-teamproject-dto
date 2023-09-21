package com.example.kakao.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderJPARepository extends JpaRepository<Order, Integer> {
    @Query("select o From Order o where o.id = :orderId and o.user.id = :userId")
    Optional<Order> findByOrderIdAndUserId(@Param("orderId") int orderId, @Param("userId") int userId);
}
