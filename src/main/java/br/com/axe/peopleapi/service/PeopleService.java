package br.com.axe.peopleapi.service;

import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Person findById(Long id) {
        Optional<Person> op = repo.findById(id);
        if(op.isPresent()) {
            return op.get();
        }
        return null;
    }

    public Person update(Long id, Person person) {
        Person person_ = findById(id);
        person_.setPhones(person.getPhones());
        person_.setFirstName(person.getFirstName());
        person_.setLastName(person.getLastName());
        person_.setBirthDate(person.getBirthDate());
        return repo.save(person_);
    }

    public Boolean delete(Long id) {
        repo.delete(findById(id));
        return true;
    }
}
