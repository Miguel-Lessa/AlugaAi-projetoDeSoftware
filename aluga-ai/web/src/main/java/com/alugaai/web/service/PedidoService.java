package com.alugaai.web.service;

import com.alugaai.web.model.Pedidos;

import java.util.List;

public interface PedidoService {
    Pedidos criarPedido(Pedidos pedido);
    List<Pedidos> listarPedidos();
    Pedidos aprovarPedido(Integer id);
}