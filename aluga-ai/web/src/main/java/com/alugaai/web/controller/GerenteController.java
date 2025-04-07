package com.alugaai.web.controller;

import com.alugaai.web.model.Automovel;
import com.alugaai.web.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GerenteController {

    @Autowired
    private AutomovelService automovelService;

    @GetMapping("/gerente/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao painel do gerente!");
        return "gerente-dashboard";
    }

    @GetMapping("/gerente/cadastroVeiculos")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("automovel", new Automovel());
        return "cadastroVeiculos"; // Nome do arquivo HTML para o formulário de cadastro
    }

    @PostMapping("/gerente/cadastroVeiculos")
    public String cadastrarAutomovel(@ModelAttribute Automovel automovel, Model model) {
        automovelService.salvarAutomovel(automovel); // Salva o automóvel no banco de dados
        model.addAttribute("mensagem", "Automóvel cadastrado com sucesso!");
        return "redirect:/gerente/dashboard"; // Redireciona para o dashboard
    }
}