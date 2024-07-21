package com.scaler.productservicejune24.Inheritancetypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "ststudent")
@DiscriminatorValue(value = "1")
public class Student extends User {
    double psp;
    double attendance;
}
