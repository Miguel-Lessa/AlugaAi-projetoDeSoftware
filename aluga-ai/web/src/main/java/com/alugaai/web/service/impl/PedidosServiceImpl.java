package com.alugaai.web.service.impl;

import com.alugaai.web.model.Pedidos;
import com.alugaai.web.repository.PedidosRepository;
import com.alugaai.web.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceImpl implements PedidoService {

    @Autowired
    private PedidosRepository pedidoRepository;

    @Override
    public Pedidos criarPedido(Pedidos pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedidos> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedidos aprovarPedido(Integer id) {
        Pedidos pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedido.setAprovado(true);
        return pedidoRepository.save(pedido);
    }
}