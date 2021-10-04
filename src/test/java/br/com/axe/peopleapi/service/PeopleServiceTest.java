package br.com.axe.peopleapi.service;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.exception.PersonNotFoundException;
import br.com.axe.peopleapi.repository.PeopleRepository;
import br.com.axe.peopleapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {
    @Mock
    private PeopleRepository repository;
    @InjectMocks
    private PeopleService service;

    @Test
    void testGivenPersonRequestThenReturnPersonResponse() {
        Person person = PersonUtils.createFakePerson();
        Mockito.when(repository.save(Mockito.any(Person.class))).thenReturn(person);
        PersonRequest req = PersonUtils.createFakePersonRequest();
        PersonResponse res = service.persist(req);

        Assertions.assertEquals(res.getId(), person.getId());
        Assertions.assertEquals(res.getFirstName(), person.getFirstName());
        Assertions.assertEquals(res.getLastName(), person.getLastName());
        Assertions.assertEquals(res.getCpf(), person.getCpf());
        Assertions.assertEquals(res.getBirthDate(), person.getBirthDate());
    }

    @Test
    void testGivenIdThenReturnPersonResponse() throws PersonNotFoundException {
        Person person = PersonUtils.createFakePerson();
        Mockito.when(repository.findById(PersonUtils.ID)).thenReturn(java.util.Optional.ofNullable(person));
        PersonResponse res = service.findById(PersonUtils.ID);
        Assertions.assertEquals(res.getId(), PersonUtils.ID);
    }
}
