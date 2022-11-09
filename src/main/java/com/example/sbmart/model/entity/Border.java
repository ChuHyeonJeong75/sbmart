package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Data@Entity@Builder
//@ToString(exclude = "customer")
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class Border {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borderNo;
    private String borderTitle;
    private String borderContents;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @ManyToOne
    //@JoinColumn(name = "customer_cust_id")
    private Customer customer;

}
