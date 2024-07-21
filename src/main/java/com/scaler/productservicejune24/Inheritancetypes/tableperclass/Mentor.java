package com.scaler.productservicejune24.Inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbcmentor")

public class Mentor extends User {
    String companyname;
    double rating;
}
