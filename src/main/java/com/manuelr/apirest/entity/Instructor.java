package com.manuelr.apirest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Cacheable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor extends Person {

    @Column(name = "salary", columnDefinition = "NUMERIC")
    private BigDecimal salary;

}
