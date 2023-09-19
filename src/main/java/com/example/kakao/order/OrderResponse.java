package com.example.kakao.order;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderResponse {

    // (기능4) 주문상품 정보조회 (유저별)

    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private ArrayList<CartDTO> carts;
        private Integer totalPrice;

        @ToString
        @Getter
        @Setter
        public static class CartDTO {
            private Integer cartId;
            private String optionName;
            private Integer price;
            private Integer quantity;
        }
    }

    // (기능5) 주문결과 확인
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {

    }
}
