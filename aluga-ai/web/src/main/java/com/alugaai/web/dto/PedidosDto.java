package com.alugaai.web.dto;

import jakarta.persistence.*;
import com.alugaai.web.model.Automovel;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PedidosDto {
    private int idAluguel;
    private Automovel veiculoAlugado;
    private boolean aprovado;
    private String propriedades;
    private boolean emContratoDeCredito;
}
