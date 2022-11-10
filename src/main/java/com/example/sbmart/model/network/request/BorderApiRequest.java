package com.example.sbmart.model.network.request;

import com.example.sbmart.model.entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.JoinColumn;
import java.sql.Blob;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class BorderApiRequest {
    private Integer borderNo;
    private String borderTitle;
    private String borderContents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String customer_cust_id;
}
