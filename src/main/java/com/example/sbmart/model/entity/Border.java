package com.example.sbmart.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
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


    @ManyToOne(cascade = CascadeType.PERSIST)
    // option = false 관계가 inner join 으로 매칭이 있어야 출력
    //fetch = FetchType.LAZY 조인 없이 테이블 호출.
    //Optional은 null을 대신, 존재할 수도, 안할 수도.

    @JoinColumn(name = "customer_cust_id" , columnDefinition = "guest" ,nullable = true)
    @ColumnDefault("guest")
    private Customer customer;

}
