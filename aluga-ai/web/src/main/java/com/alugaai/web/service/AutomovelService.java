package com.alugaai.web.service;

import com.alugaai.web.model.Automovel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutomovelService {
    private List<Automovel> automoveis = new ArrayList<>();

    public void salvarAutomovel(Automovel automovel) {
        automoveis.add(automovel); 
    }

    public List<Automovel> listarAutomoveis() {
        return automoveis;
    }
}