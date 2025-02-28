package com.darc.springrestmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Customer {

    private UUID customerId;
    private String customerName;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
