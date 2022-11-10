package com.example.sbmart.model.network.response;

import com.example.sbmart.model.entity.Customer;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class BorderApiResponse {
    private Integer borderNo;
    private String borderTitle;
    private String borderContents;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String customer_cust_id;
}
