package com.example.kakao.order;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.cart.Cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderResponse {

    // (기능4) 주문상품 정보조회 (유저별)
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        // tatalPrice는 서비스가서 구하기!
        private Integer totalPrice = 0;
        private List<CartDTO> carts;

        public FindAllByUserDTO(List<Cart> carts, Integer totalPrice) {
            this.carts = carts.stream().map(c -> new CartDTO(c))
                    .collect(Collectors.toList());
            this.totalPrice = totalPrice;
        }

        @ToString
        @Getter
        @Setter
        public static class CartDTO {
            private int cartId;
            private String optionName;
            private int cartPrice;
            private int quantity;

            public CartDTO(Cart cart) {
                this.cartId = cart.getId();
                this.optionName = cart.getOption().getProduct().getProductName() + " "
                        + cart.getOption().getOptionName();
                this.cartPrice = cart.getPrice();
                this.quantity = cart.getQuantity();
            }
        }
    }

    // (기능5) 주문결과 확인
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {

    }
}
