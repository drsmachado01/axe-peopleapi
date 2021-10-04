package br.com.axe.peopleapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long id) {
        super("Person not found for id " +  id);
    }
}
