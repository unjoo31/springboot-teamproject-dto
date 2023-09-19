package com.example.kakao.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao.order.item.Item;
import com.example.kakao.order.item.ItemJPARepository;

@DataJpaTest
public class ItemJPARepositoryTest {

    @Autowired
    private ItemJPARepository itemJPARepository;

    @Test
    public void findByAll_test() {
        List<Item> items = itemJPARepository.findAllById(1);
        for (Item item : items) {
            System.out.println("아이템즈" + item.getOption().getOptionName());
        }
    }
}
