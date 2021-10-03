package br.com.axe.peopleapi.mapper;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.request.PhoneRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.dto.response.PhoneResponse;
import br.com.axe.peopleapi.entities.Person;
import br.com.axe.peopleapi.entities.Phone;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleMapper {
    public static PersonResponse mapPersonToPersonResponse(Person person) {
        PersonResponse res = new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getCpf(),
                person.getPhones() != null ?
                mapListOfPhoneToListOfPhoneResponse(person.getPhones()) : null
        );
        return res;
    }

    public static Person mapPersonRequestToPerson(PersonRequest req) {
        return new Person(null, req.getFirstName(), req.getLastName(), req.getCpf(), req.getBirthDate(), mapListOfPhoneRequestToListOfPhone(req.getPhones()));
    }

    private static List<Phone> mapListOfPhoneRequestToListOfPhone(List<PhoneRequest> phones) {
        if(null == phones) {
            return null;
        }
        return phones.stream().map(phone -> mapPhoneRequestToPhone(phone)).collect(Collectors.toList());
    }

    private static Phone mapPhoneRequestToPhone(PhoneRequest phone) {
        return new Phone(null, phone.getType(), phone.getNumber());
    }

    public static List<PersonResponse> mapListOfPersonToListOfPersonResponse(List<Person> people) {
        if(null == people) {
            return null;
        }
        return people.stream().map(person ->
            mapPersonToPersonResponse(person)).collect(Collectors.toList());
    }

    private static List<PhoneResponse> mapListOfPhoneToListOfPhoneResponse(List<Phone> phones) {
        if(null == phones) {
            return null;
        }
        return phones.stream().map(phone -> new PhoneResponse(phone.getId(), phone.getType(), phone.getNumber()))
                .collect(Collectors.toList());
    }
}
