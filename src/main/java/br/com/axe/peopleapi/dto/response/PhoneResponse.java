package br.com.axe.peopleapi.dto.response;

import br.com.axe.peopleapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponse {
    private Long id;
    private PhoneType type;
    private String number;
}
