package br.com.axe.peopleapi.service;

import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    private PeopleRepository repo;

    @Autowired
    public PeopleService(PeopleRepository repo) {
        this.repo = repo;
    }

    public Person persist(Person person) {
        return repo.save(person);
    }

    public List<Person> list() {
        return repo.findAll();
    }
}
