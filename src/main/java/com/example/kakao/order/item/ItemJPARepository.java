package com.example.kakao.order.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemJPARepository extends JpaRepository<Item, Integer> {

    @Query("select i from Item i where i.order.id = :id")
    List<Item> findAllById(@Param("id") int id);
}
