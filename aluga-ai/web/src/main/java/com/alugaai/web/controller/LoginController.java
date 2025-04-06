package com.alugaai.web.controller;
import com.alugaai.web.model.Cliente;
import com.alugaai.web.model.Gerente;
import com.alugaai.web.model.Agente;
import com.alugaai.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.alugaai.web.service.AgenteService;
import com.alugaai.web.service.GerenteService;


@Controller
public class LoginController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private GerenteService gerenteService;

    @Autowired
    private AgenteService agenteService;

    @GetMapping("/login")
    public String loginFormPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginCliente(@RequestParam("cpf") String cpf,
                               @RequestParam("senha") String senha,
                               Model model) {
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            model.addAttribute("cliente", cliente);
            return "cliente-dashboard";
        } else {
            model.addAttribute("erro", "CPF ou senha inválidos.");
            return "login";
        }
    }
}
