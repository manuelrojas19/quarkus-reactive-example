package com.manuelr.apirest.service;

import com.manuelr.apirest.entity.Person;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface PersonService {
    Uni<List<Person>> findAll();
    Uni<Person> findById(String id);
}
