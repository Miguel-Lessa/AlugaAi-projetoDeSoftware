package com.alugai.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Cliente {

    @Id
    private String cpf;

    private String nome;
    private String senha;
    private String rg;
    private String endereco;
    private String profissao;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpregadoraModel> empregadoras;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedidos> pedidos;
}
