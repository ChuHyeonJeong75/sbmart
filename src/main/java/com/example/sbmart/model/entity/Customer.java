package com.example.sbmart.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor@AllArgsConstructor@Data@Entity
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class Customer {

    @Id
    private String custId;
}
