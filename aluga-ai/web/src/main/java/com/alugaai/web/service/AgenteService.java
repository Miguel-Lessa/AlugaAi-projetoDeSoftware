package com.alugaai.web.service;

import com.alugaai.web.dto.ClienteDto;
import com.alugaai.web.model.Cliente;
import com.alugaai.web.dto.PedidosDto;
import com.alugaai.web.model.Pedidos;

public interface AgenteService {

    void excluirPedido(int id);

    PedidosDto buscarPedidoPorCpf(String cpf);

    PedidosDto aprovarPedidos(PedidosDto pedidosDto);

}
