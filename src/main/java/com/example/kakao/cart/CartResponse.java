package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(List<Cart> cartList) {
            this.totalPrice = cartList.stream()
                    .mapToInt(cart -> cart.getPrice()).sum();
            this.products = cartList.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(cartList, product))
                    .collect(Collectors.toList());

        }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer id;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(List<Cart> cartList, Product product) {
                this.id = product.getId();
                this.productName = product.getProductName();
                this.carts = cartList.stream()
                        .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                        .map(cart -> new CartDTO(cart))
                        .collect(Collectors.toList());
            }
        }

        @Getter
        @Setter
        public class CartDTO {
            private OptionDTO option;
            private Integer cartsid;
            private Integer cartsQuantity;
            private Integer cartsPrice;

            public CartDTO(Cart cart) {
                this.option = new OptionDTO(cart.getOption());
                this.cartsid = cart.getId();
                this.cartsQuantity = cart.getQuantity();
                this.cartsPrice = cart.getPrice();
            }

        }

        @Getter
        @Setter
        public class OptionDTO {
            private Integer optionId;
            private String optionName;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
            }

        }

    }
}
