package br.com.axe.peopleapi.controller;

import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.service.PeopleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private PeopleService service;

    @Autowired
    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Person> persist(@RequestBody Person person) {
        return new ResponseEntity<>(service.persist(person), HttpStatus.OK);
    }

}
