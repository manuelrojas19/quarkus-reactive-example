package com.manuelr.apirest.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Cacheable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    @Column(name = "tot_cred", columnDefinition = "NUMERIC")
    private Integer credits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student studentEntity = (Student) o;
        return id != null && Objects.equals(id, studentEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
