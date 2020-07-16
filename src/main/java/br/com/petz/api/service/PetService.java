package br.com.petz.api.service;

import br.com.petz.api.entity.Pet;
import br.com.petz.api.payload.response.PetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PetService {
    public Page<PetResponse> findAll(Pageable pageable);
    public Optional<PetResponse> findById(Long id);
    public Optional<PetResponse> create(Pet pet);
    public void update(Long id, Pet pet);
    public void remove(Long id);
}
