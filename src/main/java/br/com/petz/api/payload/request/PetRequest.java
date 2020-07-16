package br.com.petz.api.payload.request;

import br.com.petz.api.enums.PetEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
public class PetRequest {

    private String name;

    @Enumerated(EnumType.STRING)
    private PetEnum pet;

}
