package com.scaler.productservicejune24.Inheritancetypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "stInsructor")
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    int numofsessions;
    double rating;
}
