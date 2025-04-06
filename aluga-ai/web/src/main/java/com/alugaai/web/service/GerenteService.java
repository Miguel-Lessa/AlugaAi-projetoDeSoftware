package com.alugaai.web.service;

import com.alugaai.web.model.Automovel;
import com.alugaai.web.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class GerenteService {
    @Autowired
    private AutomovelRepository automovelRepository;

    public List <Automovel> listarAutomoveis(){
        return automovelRepository.findAll();
    }  
    
    public Optional <Automovel> buscarAutomovelPorMatricula(Integer matricula){
        return automovelRepository.findById(matricula);
    }

    public Automovel cadastrarAutomovel(Automovel automovel){
        return automovelRepository.save(automovel);
    }

    public void deletarAutomovel(Integer matricula){
        automovelRepository.deleteById(matricula);
    }

    public Automovel atualizarAutomovel(Automovel automovel){
        return automovelRepository.save(automovel);
    }

    public void deletarAutomovel(int matricula){
        automovelRepository.deleteById(matricula);
    }
}
