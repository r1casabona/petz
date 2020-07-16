package br.com.petz.api.entity;

import static br.com.petz.api.constants.Constants.Persistencia.CLIENT_TABLE;
import static br.com.petz.api.constants.Constants.Models.Client.SerializedAttr.CLIENT_ID;
import static br.com.petz.api.constants.Constants.Models.Client.SerializedAttr.NAME;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = CLIENT_TABLE)
public class Client implements Serializable {

    private static final long serialVersionUID = 5338320071106041474L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=CLIENT_ID)
    private Long clientId;

    @NotBlank(message = "Nome do cliente e obrigatorio")
    @Column(name=NAME)
    private String name;
}
