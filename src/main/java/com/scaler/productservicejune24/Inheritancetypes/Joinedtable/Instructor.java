package com.scaler.productservicejune24.Inheritancetypes.Joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "jtInsructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    int numofsessions;
    double rating;
}
