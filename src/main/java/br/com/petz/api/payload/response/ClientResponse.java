package br.com.petz.api.payload.response;

import br.com.petz.api.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {

    public ClientResponse(Client client) {
        this.id = client.getClientId();
        this.name = client.getName();
    }

    private Long id;
    private String name;
}
