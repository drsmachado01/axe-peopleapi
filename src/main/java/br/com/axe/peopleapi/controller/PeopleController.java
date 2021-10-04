package br.com.axe.peopleapi.controller;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.exception.PersonNotFoundException;
import br.com.axe.peopleapi.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {

    private PeopleService service;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> list() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (PersonNotFoundException ex) {
            return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    public ResponseEntity<PersonResponse> persist(@RequestBody @Valid PersonRequest person) {
        return new ResponseEntity<>(service.persist(person), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id, @RequestBody @Valid PersonRequest person) {
        try {
            return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
        } catch (PersonNotFoundException ex) {
            return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (PersonNotFoundException ex) {
            return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.NO_CONTENT);
        }
    }

}
