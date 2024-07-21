package com.scaler.productservicejune24.Inheritancetypes.Singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "stuser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "user_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private int id;
    private String name;
    private int age;
    private String email;
    private String phonenumber;

}
