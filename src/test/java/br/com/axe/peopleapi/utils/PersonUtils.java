package br.com.axe.peopleapi.utils;

import br.com.axe.peopleapi.dto.request.PersonRequest;
import br.com.axe.peopleapi.dto.response.PersonResponse;
import br.com.axe.peopleapi.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String firstName = "Astolpho";
    private static final String lastName = "Pamphilo";
    private static final String cpf = "29419620000";
    public static final Long ID = 1L;
    private static final LocalDate birthDate = LocalDate.of(1970, 1, 1);

    public static PersonRequest createFakePersonRequest() {
        return PersonRequest
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .cpf(cpf)
                .birthDate(birthDate)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneRequest()))
                .build();
    }

    public static Person createFakePerson() {
        return Person.builder()
                .id(ID)
                .firstName(firstName)
                .lastName(lastName)
                .cpf(cpf)
                .birthDate(birthDate)
                .phones(Collections.singletonList(PhoneUtils.createFakePhone()))
                .build();
    }

    public static PersonResponse createFakePersonResponse() {
        return PersonResponse.builder()
                .id(ID)
                .firstName(firstName)
                .lastName(lastName)
                .cpf(cpf)
                .birthDate(birthDate)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneResponse()))
                .build();
    }
}
