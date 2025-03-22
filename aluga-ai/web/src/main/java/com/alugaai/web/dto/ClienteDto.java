package com.alugaai.web.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ClienteDto {
    private String cpf;
    private String nome;
    private String senha;
    private String rg;
    private String endereco;
    private String profissao;
    private List<String> empregadoras;
    private List<Double> rendimentos;
}
