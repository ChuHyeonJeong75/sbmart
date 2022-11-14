package com.example.sbmart.model.network.response;

import lombok.*;
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class ProductApiResponse {
    private Integer productNo;
    private String productName;
    private Integer totalStock;
    private Integer price;
}
