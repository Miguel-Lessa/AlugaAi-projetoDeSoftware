package com.alugaai.web.controller;

import com.alugaai.web.service.ClienteService;
import com.alugaai.web.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/login")
    public String loginForm() {
        return "cliente-login";
    }

    @PostMapping("/cliente/excluir")
    public String excluirCliente(@RequestParam("cpf") String cpf) {
        clienteService.excluirCliente(cpf);
        return "redirect:/login";
    }

    @GetMapping("/cliente/novo")
    public String criaClienteForm(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", new Cliente());
        return "cliente-create";
    }

    @PostMapping("/cliente/novo")
    public String salvarClient(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "redirect:/login";
    }

}
