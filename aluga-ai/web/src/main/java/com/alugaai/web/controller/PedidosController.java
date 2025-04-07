package com.alugaai.web.controller;

import com.alugaai.web.model.Automovel;
import com.alugaai.web.model.Pedidos;
import com.alugaai.web.service.AutomovelService;
import com.alugaai.web.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/novo")
    public String exibirFormularioPedido(Model model) {
        List<Automovel> automoveis = automovelService.listarAutomoveis(); // Busca os carros do banco
        Pedidos novoPedido = new Pedidos();
        novoPedido.setAutomovel(new Automovel()); // Inicializa o objeto Automovel
        model.addAttribute("automoveis", automoveis);
        model.addAttribute("pedido", novoPedido);
        return "formularioPedido"; 
    }


    @GetMapping("/listar")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "listaPedidos";
    }

    @PostMapping("/aprovar/{id}")
    public String aprovarPedido(@PathVariable Long id, Model model) {
        Pedidos pedido = pedidoService.aprovarPedido(id.intValue());
        boolean aprovado = pedido.getStatus();
        if (true) {
            model.addAttribute("mensagem", "Pedido aprovado com sucesso!");
        } else {
            model.addAttribute("erro", "Erro ao aprovar o pedido. Verifique o status.");
        }
        return "redirect:/pedidos/listar";
    }

    
}