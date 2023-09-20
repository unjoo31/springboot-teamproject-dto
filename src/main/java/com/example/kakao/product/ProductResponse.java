package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.product.option.Option;

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

        public FindAllDTO(Product product) {
            this.productId = product.getId();
            this.delivery = 1;
            this.image = product.getImage();
            this.productName = product.getProductName();
            this.price = product.getPrice();
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

        public FindByIdDTO(Product product, List<Option> optionList) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();
            this.startCount = 4;
            this.options = optionList.stream()
                                        .map(option -> new OptionDTO(option))
                                        .collect(Collectors.toList());
        }         
        
            @ToString
            @Getter
            @Setter
            public static class OptionDTO{
            private Integer optionId;
            private String optionName;
            private int optionPrice;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }      
        }
    }    
}