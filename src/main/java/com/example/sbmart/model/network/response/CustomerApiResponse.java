package com.example.sbmart.model.network.response;

import lombok.*;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class CustomerApiResponse {
    private String custId;
    private String password;
    private String name;
    private Integer age;
    private String job;
}
