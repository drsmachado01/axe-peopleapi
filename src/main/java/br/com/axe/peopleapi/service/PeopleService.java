package br.com.axe.peopleapi.service;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.mapper.PeopleMapper;
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

    public PersonResponse persist(PersonRequest person) {
        return PeopleMapper.mapPersonToPersonResponse(repo.save(PeopleMapper.mapPersonRequestToPerson(person)));
    }

    public List<PersonResponse> list() {
        return PeopleMapper.mapListOfPersonToListOfPersonResponse(repo.findAll());
    }

    public PersonResponse findById(Long id) {
        Optional<Person> op = repo.findById(id);
        if(op.isPresent()) {
            return PeopleMapper.mapPersonToPersonResponse(op.get());
        }
        return null;
    }

    public PersonResponse update(Long id, PersonRequest person) {
        Person person_ = repo.findById(id).get();
        person_.setPhones(PeopleMapper.mapPersonRequestToPerson(person).getPhones());
        person_.setFirstName(person.getFirstName());
        person_.setLastName(person.getLastName());
        person_.setBirthDate(person.getBirthDate());
        return PeopleMapper.mapPersonToPersonResponse(repo.save(person_));
    }

    public Boolean delete(Long id) {
        repo.delete(repo.findById(id).get());
        return true;
    }
}
