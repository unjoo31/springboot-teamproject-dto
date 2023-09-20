package com.example.kakao.cart;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.loadtime.Options;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer id;
        private ArrayList<ProductDTO> products;
        private Integer totalPrice;

        public FindAllByUserDTO(Integer id, ArrayList<ProductDTO> products, Integer totalPrice) {
            this.id = id;
            this.products = products;
            this.totalPrice = totalPrice;
        }
    }

    @Getter
    @Setter
    public class ProductDTO {
        private Integer productId;
        private String productName;
        private ArrayList<OptionDTO> Options;

        public ProductDTO(Product product, ArrayList<OptionDTO> options) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.Options = options;
        }

    }

    @Getter
    @Setter
    public class OptionDTO {
        private Integer optionId;
        private String optionName;
        private ArrayList<CartDTO> carts;

        public OptionDTO(Option option, ArrayList<CartDTO> carts) {
            this.optionId = option.getId();
            this.optionName = option.getOptionName();
            this.carts = carts;
        }

    }

    @Getter
    @Setter
    public class CartDTO {
        private Integer cartId;
        private Integer cartsQuantity;
        private Integer cartsPrice;

        public CartDTO(Cart cart) {
            this.cartId = cart.getId();
            this.cartsQuantity = cart.getQuantity();
            this.cartsPrice = cart.getPrice();
        }

    }

}
