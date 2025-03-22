package com.alugaai.web.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.alugaai.web.model.Automovel;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    private int idAluguel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")  //
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "matricula")
    private Automovel veiculoAlugado;
    private boolean aprovado;
    private String propriedades;
    private boolean emContratoDeCredito;
}
