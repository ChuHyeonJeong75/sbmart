package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor@AllArgsConstructor@Data@Entity@Builder
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class OrderTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNo;
}
