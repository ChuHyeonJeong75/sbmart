package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Entity
@DynamicUpdate  // 수정할 데이타만 업뎃
@Builder
@ToString(exclude = "customer")
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

    @ManyToOne(fetch =FetchType.LAZY , cascade = CascadeType.PERSIST, optional = false)
    // option = false 관계가 inner join 으로 매칭이 있어야 출력
    //fetch = FetchType.LAZY 조인 없이 테이블 호출.
    //optional은 null을 대신, 존재할 수도, 안할 수도.
    //Column(insertable = true, updatable = false) // 입력할때는 OK, 수정할때는 수정안되게!
    @JoinColumn(name = "customer_cust_id", nullable = true)
    @ColumnDefault("guest")
    //@Column(insertable=false, updatable=false , nullable = true)
    private Customer customer;

}