package com.alugaai.web.service.impl;

import com.alugaai.web.dto.ClienteDto;
import com.alugaai.web.dto.PedidosDto;
import com.alugaai.web.model.Cliente;
import com.alugaai.web.model.Pedidos;
import com.alugaai.web.repository.ClienteRepository;
import com.alugaai.web.repository.PedidosRepository;
import com.alugaai.web.service.AgenteService;
import com.alugaai.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AgenteServiceImplementation implements AgenteService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    public PedidosDto buscarPedidoPorCpf(String cpf) {
        Pedidos pedido = pedidosRepository.findByClienteCpf(cpf)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado para o CPF fornecido"));
        
        return PedidosDto.builder()
            .idAluguel(pedido.getIdAluguel())
            .propriedades(pedido.getCliente().getNome())
            .build();
    }

    @Override
    public void excluirPedido(int idAluguel) {
        Pedidos pedido = pedidosRepository.findById(idAluguel)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado para o ID fornecido"));
        pedidosRepository.delete(pedido);
    }

    @Override
    public PedidosDto aprovarPedidos (PedidosDto pedidosDto){
        Pedidos pedido = pedidosRepository.findById(pedidosDto.getIdAluguel())
        .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    
        pedido.setAprovado(true);
        
        pedidosRepository.save(pedido);

        return pedidosDto.builder()
            .idAluguel(pedido.getIdAluguel()) 
            .propriedades (pedido.getCliente().getNome())
            .build();

    }


}
