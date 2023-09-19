package com.example.kakao.order;

import java.util.ArrayList;
import java.util.List;

import com.example.kakao.cart.Cart;
import com.example.kakao.order.item.Item;
import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderResponse {

    // (기능4) 주문상품 정보조회 (유저별)
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {

    }

    // (기능5) 주문결과 확인
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {

        private int orderId;
        private List<OrderItemDTO> orderItemDTOList;
        private int totalPrice;

        public FindByIdDTO(Item item, List<OrderItemDTO> orderItemDTO, int totalPrice) {
            this.orderId = item.getOrder().getId();
            this.orderItemDTOList = orderItemDTOList;
            this.totalPrice = totalPrice;
        }
    }

    @ToString
    @Getter
    @Setter
    public class OrderItemDTO {
        private int productId;
        private String productName;
        private List<OptionItemDTO> optionItemDTOList;

        public OrderItemDTO(Product product, List<OptionItemDTO> optionItemDTOList) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.optionItemDTOList = optionItemDTOList;
        }
    }

    @ToString
    @Getter
    @Setter
    public class OptionItemDTO {
        private int optionId;
        private String optionName;
        private int quantity;
        private int price;

        public OptionItemDTO(Item item) {
            this.optionId = item.getOption().getId();
            this.optionName = item.getOption().getOptionName();
            this.quantity = item.getQuantity();
            this.price = item.getPrice();
        }
    }
}
