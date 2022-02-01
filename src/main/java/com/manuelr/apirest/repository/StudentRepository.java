package com.manuelr.apirest.repository;

import com.manuelr.apirest.entity.Person;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@com.manuelr.apirest.annotations.StudentRepository
public class StudentRepository implements PersonRepository {

    @Override
    public Uni<List<Person>> listAll() {
        return list("SELECT s FROM Student s");
    }

    @Override
    public Uni<List<Person>> listAll(Sort sort) {
        return list("SELECT s FROM Student s", sort);
    }

}
