package com.example.sbmart.model.network.request;

import lombok.*;
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class ProductApiRequest {
    private Integer productNo;
    private String productName;
    private Integer totalStock;
    private Integer price;
}
