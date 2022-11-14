package com.example.sbmart.model.network.request;

import com.example.sbmart.model.entity.Customer;
import com.example.sbmart.model.entity.Product;
import lombok.*;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class OrderTblApiRequest {
    private Integer orderNo;
    private Integer orderCount;
    private String address;
    private String customerCustId;
    private Integer productProductNo;
}
