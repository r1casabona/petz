package br.com.petz.api.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ClientRequest {

    @NotBlank(message = "Campo obrigatório")
    private String name;
}
