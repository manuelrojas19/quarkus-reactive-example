package com.manuelr.apirest.rest;

import com.manuelr.apirest.annotations.StudentServiceImpl;
import com.manuelr.apirest.service.PersonService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/api/v1/students")
@Produces("application/json")
@Consumes("application/json")
public class StudentResource {

    @Inject
    @StudentServiceImpl
    PersonService personService;

    @GET
    public Uni<Response> findAll() {
        return personService.findAll()
                .onItem().transform(student -> Response.ok(student).build());
    }

    @GET
    @Path("/{id}")
    public Uni<Response> findById(@PathParam("id") String id) {
        return personService.findById(id)
                .onItem().transform(student -> Response.ok(student).build());
    }
}
