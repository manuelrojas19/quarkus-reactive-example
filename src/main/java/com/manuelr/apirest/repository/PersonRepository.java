package com.manuelr.apirest.repository;

import com.manuelr.apirest.entity.Person;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

public interface PersonRepository extends PanacheRepositoryBase<Person, String> {
}
