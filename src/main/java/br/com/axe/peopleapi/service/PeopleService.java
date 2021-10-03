package br.com.axe.peopleapi.service;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.mapper.PeopleMapper;
import br.com.axe.peopleapi.mapper.PersonMapper;
import br.com.axe.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    private PeopleRepository repo;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PeopleService(PeopleRepository repo) {
        this.repo = repo;
    }

    public PersonResponse persist(PersonRequest personRequest) {
        Person person = personMapper.toModel(personRequest);
        return personMapper.toDTO(repo.save(person));
    }

    public List<PersonResponse> list() {
        List<Person> people = repo.findAll();
        return people.stream().map(person -> personMapper.toDTO(person))
                .collect(Collectors.toList());
    }

    public PersonResponse findById(Long id) {
        Optional<Person> op = repo.findById(id);
        if(op.isPresent()) {
            return personMapper.toDTO(op.get());
        }
        return null;
    }

    public PersonResponse update(Long id, PersonRequest personRequest) {
        Person person = personMapper.toModel(personRequest);
        Person person_ = repo.findById(id).get();
        person_.setPhones(person.getPhones());
        person_.setFirstName(person.getFirstName());
        person_.setLastName(person.getLastName());
        person_.setBirthDate(person.getBirthDate());
        return personMapper.toDTO(repo.save(person_));
    }

    public Boolean delete(Long id) {
        repo.delete(repo.findById(id).get());
        return true;
    }
}
