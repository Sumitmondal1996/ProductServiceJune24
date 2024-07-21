package com.scaler.productservicejune24.Inheritancetypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "stmentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    String companyname;
    double rating;
}
