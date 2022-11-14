package com.example.sbmart.model.network.response;

import com.example.sbmart.model.entity.Product;
import lombok.*;

import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class OrderTblApiResponse {
    private Integer orderNo;
    private String customerCustId;
    private String customerName;
    private String address;
    private Integer productProductNo;
    private String productName;
    private Integer productPrice;
    private Integer orderCount;
    private Integer totalPrice;
    private LocalDateTime orderDate;

}
