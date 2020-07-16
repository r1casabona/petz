package br.com.petz.api.controller;

import static br.com.petz.api.constants.Constants.Routes.ROUTE_CLIENT;

import br.com.petz.api.entity.Client;
import br.com.petz.api.payload.request.ClientRequest;
import br.com.petz.api.payload.response.ClientResponse;
import br.com.petz.api.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping(value = ROUTE_CLIENT)
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientRequest request) {
        Optional<ClientResponse> clientResponse = clientService.create(this.mountClient(request));
        return (clientResponse.isPresent())
                ?new ResponseEntity<>(clientResponse.get(), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@NotNull @PathVariable Long id) {
        Optional<ClientResponse> clientResponse = clientService.findById(id);
        return (clientResponse.isPresent())
                ?new ResponseEntity<>(clientResponse.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Client client) {
        clientService.update(id, client);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.remove(id);
    }



    private Client mountClient(ClientRequest request) {
        return Client.builder().name(request.getName()).build();
    }

}
