package com.scaler.productservicejune24.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable { // Serializable is used when you want to send the data over network as JSON object, to implements Redis we have used here
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private long id;
    private Date createdAt;
    private Date updatedAt;

}
