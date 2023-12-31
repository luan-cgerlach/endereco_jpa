package com.example.endereco_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    private Long id;
    private String rua;
    private String cidade;
    private String entado;
    private String cep;

    //@JsonIgnoreProperties
    @JsonIgnore
    @OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;
}
