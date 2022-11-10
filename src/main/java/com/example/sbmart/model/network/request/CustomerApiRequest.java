package com.example.sbmart.model.network.request;

import lombok.*;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class CustomerApiRequest {
    private String custId;
    private String password;
    private String name;
    private Integer age;
    private String job;
}
