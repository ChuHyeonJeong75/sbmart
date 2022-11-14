package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Entity
@DynamicUpdate  // 수정할 데이타만 업뎃
//@DynamicInsert  // 수정할 데이타만 인서트
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = true)  //fetch = FetchType.EAGER ManyToOne의 기본타입
    @Fetch(FetchMode.JOIN)    // outer left join
    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, option = false)    //inner join
    //@ManyToOne( optional = false )관계가 inner join 으로 매칭이 있어야 출력, optional = true 면 조인 테이블 각각 select 됨
    //fetch = FetchType.LAZY 조인 없이 각각  테이블 호출.
    //fetch = FetchType.EAGER ManyToOne의 기본타입 , inner join으로 처리
    //optional은 null을 대신, 존재할 수도, 안할 수도.
    //Column(insertable = true, updatable = false) // 입력할때는 OK, 수정할때는 수정안되게!
    // N+1 문제 : 쿼리가 여러개 ㅜ.ㅜ
   // @JoinColumn(name = "customer_cust_id" , nullable = true)
    @ColumnDefault("guest")
    @Nullable
    private Customer customer;

}