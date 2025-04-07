package com.alugaai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgenteController {

    @GetMapping("/agente/dashboard")
    public String agenteDashboard() {
        return "agente-dashboard"; // Nome do arquivo HTML estático
    }
}