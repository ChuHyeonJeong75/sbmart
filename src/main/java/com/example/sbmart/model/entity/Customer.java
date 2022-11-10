package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Data@Entity@Builder
@ToString(exclude = {"borderList"})
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class Customer {

    @Id
    @Column(name = "cust_id")
    private String custId;

    private String password;
    private String name;
    private Integer age;
    private String job;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "customer" )
    private List<Border> borderList;
}
