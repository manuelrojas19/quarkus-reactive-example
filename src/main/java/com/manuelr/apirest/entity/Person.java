package com.manuelr.apirest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected String id;

    @Column(length = 20)
    protected String name;
}
