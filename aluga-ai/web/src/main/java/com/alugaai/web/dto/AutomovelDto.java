package com.alugaai.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutomovelDto {
    private int matricula;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private String posse;
    private boolean alugado;
}
