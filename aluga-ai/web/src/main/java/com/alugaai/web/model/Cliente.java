package com.alugaai.web.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf; 
    private String nome;
    private String senha;
    private String rg;
    private String endereco;
    private String profissao;

    @ElementCollection  
    @CollectionTable(name = "clientes_rendimentos", joinColumns = @JoinColumn(name = "cpf_cliente"))
    private List<Double> rendimentos;  

    @ElementCollection 
    @CollectionTable(name = "clientes_empregadoras", joinColumns = @JoinColumn(name = "cpf_cliente"))
    private List<String> empregadoras;  

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedidos> pedidos; 
}
