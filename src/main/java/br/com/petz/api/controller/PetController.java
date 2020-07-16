package br.com.petz.api.controller;

import static br.com.petz.api.constants.Constants.Routes.ROUTE_PET;

import br.com.petz.api.entity.Client;
import br.com.petz.api.entity.Pet;
import br.com.petz.api.payload.request.PetRequest;
import br.com.petz.api.payload.response.PetResponse;
import br.com.petz.api.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(value = ROUTE_PET)
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/client/{clientId}/pets")
    public ResponseEntity<PetResponse> create(@PathVariable(value = "clientId") Long clientId,
                                              @Valid @RequestBody PetRequest petRequest) {
        Optional<PetResponse> response = petService.create(this.mountPet(clientId, petRequest));
        return (response.isPresent()) ? new ResponseEntity<>(response.get(), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> findById(@NotNull @PathVariable Long id) {
        Optional<PetResponse> response = petService.findById(id);
        return (response.isPresent()) ? new ResponseEntity<>(response.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Pet pet) {
        petService.update(id, pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.remove(id);
    }

    private Pet mountPet(Long clientId, PetRequest petRequest) {
        return Pet.builder().client(Client.builder().clientId(clientId).build())
                .name(petRequest.getName())
                .pet(petRequest.getPet()).build();
    }


}
