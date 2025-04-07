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

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "123";

    private static final String AGENT_USER = "agente";
    private static final String AGENT_PASS = "123";
    
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
    public String login(@RequestParam("cpf") String cpf,
                    @RequestParam("senha") String senha,
                    @RequestParam(value = "tipoUsuario", required = false) String tipoUsuario,
                    Model model) {
    if ("admin".equals(tipoUsuario) && ADMIN_USER.equals(cpf) && ADMIN_PASS.equals(senha)) {
        return "redirect:/gerente/dashboard"; 
    } else if ("agente".equals(tipoUsuario) && AGENT_USER.equals(cpf) && AGENT_PASS.equals(senha)) {
        return "redirect:/agente/dashboard";
    } else {
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if ("cliente".equals(tipoUsuario) && cliente != null && cliente.getSenha().equals(senha)) {
            model.addAttribute("cliente", cliente);
            return "cliente-dashboard"; 
        } else {
                model.addAttribute("erro", "CPF, senha ou tipo de usuário inválidos.");
                return "login"; // Retorna à página de login com mensagem de erro
            }
        }
    }
}
