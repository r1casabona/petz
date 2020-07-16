package br.com.petz.api.service.impl;

import br.com.petz.api.entity.Pet;
import br.com.petz.api.payload.response.PetResponse;
import br.com.petz.api.repository.PetRepository;
import br.com.petz.api.service.PetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Page<PetResponse> findAll(Pageable pageable) {
        Page<Pet> listClient = petRepository.findAll(pageable);
        return listClient.map(PetResponse::new);
    }

    @Override
    public Optional<PetResponse> findById(Long id) {
        return Optional.ofNullable(new PetResponse(petRepository.getOne(id)));
    }

    @Override
    public Optional<PetResponse> create(Pet pet) {
        return Optional.ofNullable(new PetResponse(petRepository.save(pet)));
    }

    @Override
    public void update(Long id, Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void remove(Long id) {
        petRepository.deleteById(id);
    }
}
