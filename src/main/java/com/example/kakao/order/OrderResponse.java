package com.example.kakao.order;

import java.util.List;

import com.example.kakao.order.item.Item;

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
    public static class FindByIdDTO { // orderId + totalPrice

        private int orderId;
        private List<OrderItemDTO> orderItemDTOs;
        private int totalPrice;

        public FindByIdDTO(Item item, List<OrderItemDTO> orderItemDTOs, int totalPrice) {
            this.orderId = item.getOrder().getId();
            this.orderItemDTOs = orderItemDTOs;
            this.totalPrice = totalPrice;
        }

        @ToString
        @Getter
        @Setter
        public class OrderItemDTO { // productId
            private int productId;
            private String productName;
            private List<OptionItemDTO> optionItemDTOs;

            public OrderItemDTO(Item item, List<OptionItemDTO> optionItemDTO) {
                this.productId = item.getOption().getProduct().getId();
                this.productName = item.getOption().getProduct().getProductName();
                this.optionItemDTOs = optionItemDTOs;
            }

            @ToString
            @Getter
            @Setter
            public class OptionItemDTO { // optionId + itemQuantity | itemPrice
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

    }

}
