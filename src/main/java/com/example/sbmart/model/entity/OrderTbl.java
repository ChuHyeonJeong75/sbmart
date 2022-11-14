package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Entity
@DynamicUpdate  // 수정할 데이타만 업뎃
@Builder
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@ToString(exclude = {"customer","product"})
public class OrderTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNo;

    private Integer orderCount;
    private String address;

    @CreatedDate
    private LocalDateTime orderDate;

    //N:1
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_cust_id")
    private Customer customer;

    //M:1
    @ManyToOne(optional = false)
    @JoinColumn(name = "Product_product_no")
    private Product product;
}
