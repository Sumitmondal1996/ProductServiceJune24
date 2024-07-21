package com.scaler.productservicejune24.Inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "tbcInsructor")

public class Instructor extends User {
    int numofsessions;
    double rating;
}
