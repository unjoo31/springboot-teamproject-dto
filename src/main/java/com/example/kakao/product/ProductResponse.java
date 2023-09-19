package com.example.kakao.product;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer productId;
        private Integer delivery;
        private String image;
        private String productName;
        private int price;

        public FindAllDTO(Integer productId, Integer delivery, String image, String productName, int price) {
            this.productId = productId;
            this.delivery = delivery;
            this.image = image;
            this.productName = productName;
            this.price = price;
        }        
    }

    // (기능2) 상품 상세보기
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer productId;
        private String productName;
        private String image;
        private int price;
        private int startCount;
        private List<OptionDTO> options;

        public FindByIdDTO(Integer productId, String productName, String image, int price, int startCount,
                List<OptionDTO> options) {
            this.productId = productId;
            this.productName = productName;
            this.image = image;
            this.price = price;
            this.startCount = startCount;
            this.options = options;
        }        
    }

    @ToString
    @Getter
    @Setter
    public static class OptionDTO{
        private Integer optionId;
        private String optionName;
        private int optionPrice;

        public OptionDTO(Integer optionId, String optionName, int optionPrice) {
            this.optionId = optionId;
            this.optionName = optionName;
            this.optionPrice = optionPrice;
        }      
    }
}