package com.alugai.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pedidos {
    private Automovel veiculoAlugado;
    private int idAluguel;
    private boolean aprovado;
    private String propriedades;
    private boolean emContratoDeCredito;
}
