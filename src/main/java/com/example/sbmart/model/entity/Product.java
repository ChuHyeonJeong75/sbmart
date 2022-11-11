package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor@Entity
@DynamicUpdate(value = true)  // 수정할 데이타만 업뎃
@Builder
@ToString(exclude = {"orderTblList"})
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productNo;

    private String productName;
    private Integer totalStock;
    private Integer price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderTbl> orderTblList;

}
