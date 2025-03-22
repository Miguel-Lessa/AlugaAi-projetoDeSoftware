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

public class Automovel {
    private String marca;
    private String modelo;
    private int ano;
    private int matricula;
    private String placa;
    private String posse;
    private boolean alugado;
}
