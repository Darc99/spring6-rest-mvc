package com.darc.springrestmvc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR) //added this because hibernate was trying to store a binary into a string. So this converts the uuid into a string
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID customerId;
    private String customerName;

    @Column(length = 255)
    private String email;

    @Version
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
