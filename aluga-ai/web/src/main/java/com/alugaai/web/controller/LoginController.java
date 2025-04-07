package com.alugaai.web.controller;

import com.alugaai.web.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.alugaai.web.service.ClienteService;

@Controller
public class LoginController {

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "123";

    private static final String AGENT_USER = "agente";
    private static final String AGENT_PASS = "123";
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/login")
    public String loginFormPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("cpf") String cpf,
                        @RequestParam("senha") String senha,
                        @RequestParam(value = "tipoUsuario", required = false) String tipoUsuario,
                        Model model) {
        if ("admin".equals(tipoUsuario) && ADMIN_USER.equals(cpf) && ADMIN_PASS.equals(senha)) {
            return "redirect:/gerente/dashboard"; 
        } else if ("gerente".equals(tipoUsuario)) {
            return "redirect:/gerente/dashboard";
        } else if ("agente".equals(tipoUsuario)) {
            return "redirect:/agente/dashboard"; // Redireciona diretamente
        } else {
            Cliente cliente = clienteService.buscarPorCpf(cpf);
            if ("cliente".equals(tipoUsuario) && cliente != null && cliente.getSenha().equals(senha)) {
                model.addAttribute("cliente", cliente);
                return "cliente-dashboard"; 
            } else {
                model.addAttribute("erro", "CPF, senha ou tipo de usuário inválidos.");
                return "login";
            }
        }
    }
}