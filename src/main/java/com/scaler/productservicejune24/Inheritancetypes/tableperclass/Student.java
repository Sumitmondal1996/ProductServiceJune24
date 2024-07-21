package com.scaler.productservicejune24.Inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "tbcstudent")

public class Student extends User {
    double psp;
    double attendance;
}
