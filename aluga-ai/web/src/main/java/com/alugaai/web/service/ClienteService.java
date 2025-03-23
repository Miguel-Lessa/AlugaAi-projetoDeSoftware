package com.alugaai.web.service;

import com.alugaai.web.dto.ClienteDto;
import com.alugaai.web.model.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {
    Cliente salvarCliente(Cliente cliente);

    void atualizarCliente(ClienteDto clienteDto);

    void excluirCliente(String idCliente);

    Cliente criarNovoPedido();


    Cliente buscarPorCpf(String cpf);
}
