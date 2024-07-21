package com.scaler.productservicejune24.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private long id;
    private Date createdAt;
    private Date updatedAt;

}
