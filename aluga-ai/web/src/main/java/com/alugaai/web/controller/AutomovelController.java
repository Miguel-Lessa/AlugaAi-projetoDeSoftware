package com.alugaai.web.controller;

import com.alugaai.web.model.Automovel;
import com.alugaai.web.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@RestController
@RequestMapping ("/automovel")
public class AutomovelController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public List<Automovel> listarAutomoveis(){
        return gerenteService.listarAutomoveis();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Automovel> buscarAutomovelPorMatricula(@PathVariable int matricula){
        return gerenteService.buscarAutomovelPorMatricula(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Automovel cadastrarAutomovel(@RequestBody Automovel automovel){
        return gerenteService.cadastrarAutomovel(automovel);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Automovel> atualizarAutomovel(@PathVariable int matricula, @RequestBody Automovel automovel){
        if (!gerenteService.buscarAutomovelPorMatricula(matricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        automovel.setMatricula(matricula);
        Automovel automovelAtualizado = gerenteService.atualizarAutomovel(automovel);
        return ResponseEntity.ok(automovelAtualizado);
    }
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletarAutomovel(@PathVariable int matricula){
        if (!gerenteService.buscarAutomovelPorMatricula(matricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        gerenteService.deletarAutomovel(matricula);
        return ResponseEntity.noContent().build();
    }
    
}
