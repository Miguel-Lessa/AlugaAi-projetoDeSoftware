package com.alugaai.web.service;

import com.alugaai.web.model.Automovel;
import org.springframework.stereotype.Service;
import com.alugaai.web.model.Automovel;
import com.alugaai.web.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutomovelService {
    private List<Automovel> automoveis = new ArrayList<>();

    @Autowired
    private AutomovelRepository automovelRepository;

    public void salvarAutomovel(Automovel automovel) {
        automovelRepository.save(automovel);
    }

    public List<Automovel> listarAutomoveis() {
        return automovelRepository.findAll();
    }
}