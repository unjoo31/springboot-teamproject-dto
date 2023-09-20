package com.example.kakao.product.option;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionJPARepository extends JpaRepository<Option, Integer> {

    List<Option> findByProductId(int id);

}
