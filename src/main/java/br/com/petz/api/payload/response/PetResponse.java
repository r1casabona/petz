package br.com.petz.api.payload.response;

import br.com.petz.api.entity.Pet;
import br.com.petz.api.enums.PetEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetResponse {

    public PetResponse(Pet pet) {
        this.name = pet.getName();
        this.pet = pet.getPet();
    }

    private String name;

    private PetEnum pet;
}
