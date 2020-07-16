package br.com.petz.api.service;

import br.com.petz.api.entity.Client;
import br.com.petz.api.payload.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    public Page<ClientResponse> findAll(Pageable pageable);
    public Optional<ClientResponse> findById(Long id);
    public Optional<ClientResponse> create(Client client);
    public void update(Long id, Client client);
    public void remove(Long id);
}
