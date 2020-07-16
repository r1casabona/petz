package br.com.petz.api.entity;

import static br.com.petz.api.constants.Constants.Models.Client.SerializedAttr.CLIENT_ID;
import static br.com.petz.api.constants.Constants.Persistencia.PET_TABLE;
import static br.com.petz.api.constants.Constants.Models.Pet.SerializedAttr.PET_ID;
import static br.com.petz.api.constants.Constants.Models.Pet.SerializedAttr.NAME;
import static br.com.petz.api.constants.Constants.Models.Pet.SerializedAttr.PET;

import br.com.petz.api.enums.PetEnum;
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
@Table(name = PET_TABLE)
public class Pet implements Serializable {
    private static final long serialVersionUID = 3345039111948733894L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=PET_ID)
    private Long petId;

    @NotBlank(message = "Nome do Pet obrigatorio")
    @Column(name=NAME)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name=PET)
    private PetEnum pet;

    @ManyToOne
    @JoinColumn(name = CLIENT_ID, nullable = false)
    private Client client;
}
