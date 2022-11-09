package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Data@Entity@Builder
@ToString(exclude = {"borderList"})
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class Customer {

    @Id
    private String custId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "customer")
    private List<Border> borderList;
}
