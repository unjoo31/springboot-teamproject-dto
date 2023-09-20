package com.example.kakao.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.order.OrderResponse.FindByIdDTO;
import com.example.kakao.order.item.Item;
import com.example.kakao.order.item.ItemJPARepository;

@DataJpaTest
public class OrderServiceTest {

    @Autowired
    private OrderJPARepository orderJPARepository;

    @Autowired
    private ItemJPARepository itemJPARepository;

    @Test
    public void findById_test() {
        // 1. 유저 주문목록 조회
        Order orderPS = orderJPARepository.findByOrderIdAndUserId(1, 1)
                .orElseThrow(() -> new Exception404("해당 주문을 찾을 수 없습니다 : " + 1));
        System.out.println("테스트 : orderPS - " + orderPS.getId());

        // 2. 유저 주문 아이템 조회
        List<Item> items = itemJPARepository.findAllById(1);
        if (items == null) {
            throw new Exception404("해당 주문 아이템을 찾을 수 없습니다 : " + 1);
        }
        System.out.println("테스트 : items - " + items.get(0).getOption().getOptionName());

        // 3. 주문 -> 결과 DTO
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        System.out.println("테스트 : totalPrice - " + totalPrice);

        OrderResponse.FindByIdDTO responseDTO = new FindByIdDTO(orderPS, items, totalPrice);

    }
}
