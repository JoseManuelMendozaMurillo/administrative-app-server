package com.ventuit.adminstrativeapp.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity, Integer id) {
        super(entity + " not found with ID: " + id);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

}
