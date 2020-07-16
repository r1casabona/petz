package br.com.petz.api.service.impl;

import br.com.petz.api.entity.Client;
import br.com.petz.api.payload.response.ClientResponse;
import br.com.petz.api.repository.ClientRepository;
import br.com.petz.api.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Page<ClientResponse> findAll(Pageable pageable) {
        Page<Client> listClient = clientRepository.findAll(pageable);
        return listClient.map(ClientResponse::new);
    }

    @Override
    public Optional<ClientResponse> findById(Long id) {
        return Optional.ofNullable(new ClientResponse(clientRepository.getOne(id)));
    }

    @Override
    public Optional<ClientResponse> create(Client client) {
        return Optional.ofNullable(new ClientResponse( clientRepository.save(client)));
    }

    @Override
    public void update(Long id, Client client)  {
        clientRepository.save(client);
    }

    @Override
    public void remove(Long id)  {
        clientRepository.deleteById(id);
    }
}
