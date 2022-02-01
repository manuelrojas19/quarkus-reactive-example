package com.manuelr.apirest.service.impl;

import com.manuelr.apirest.annotations.StudentRepository;
import com.manuelr.apirest.entity.Person;
import com.manuelr.apirest.exception.NotFoundException;
import com.manuelr.apirest.repository.PersonRepository;
import com.manuelr.apirest.service.PersonService;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.unchecked.Unchecked;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@com.manuelr.apirest.annotations.StudentServiceImpl
public class StudentServiceImpl implements PersonService {
    private static final String NOT_FOUND_ERROR_MSG = "Student not Found";

    @Inject
    @StudentRepository
    PersonRepository personRepository;

    public Uni<List<Person>> findAll() {
        return personRepository.listAll(Sort.by("id"))
                .onItem().invoke(Unchecked.consumer(list -> {
                    if (list.isEmpty())
                        throw new NotFoundException(NOT_FOUND_ERROR_MSG);
                }));
    }

    public Uni<Person> findById(String id) {
        return personRepository.findById(id)
                .onItem().ifNull().failWith(() -> new NotFoundException(NOT_FOUND_ERROR_MSG));
    }
}
