package com.scaler.productservicejune24.Inheritancetypes.Joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "jtuser")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private int id;
    private String name;
    private int age;
    private String email;
    private String phonenumber;

}
