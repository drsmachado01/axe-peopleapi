package br.com.axe.peopleapi.utils;

import br.com.axe.peopleapi.dto.request.PhoneRequest;
import br.com.axe.peopleapi.dto.response.PhoneResponse;
import br.com.axe.peopleapi.entities.Phone;
import br.com.axe.peopleapi.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "41999998888";
    private static final PhoneType TYPE = PhoneType.MOBILE;
    private static final Long ID = 1L;

    public static PhoneRequest createFakePhoneRequest() {
        return PhoneRequest.builder()
                .number(PHONE_NUMBER)
                .type(TYPE)
                .build();
    }

    public static Phone createFakePhone() {
        return Phone.builder()
                .type(TYPE)
                .id(ID)
                .build();
    }

    public static PhoneResponse createFakePhoneResponse() {
        return PhoneResponse.builder()
                .type(TYPE)
                .id(ID)
                .build();
    }
}
