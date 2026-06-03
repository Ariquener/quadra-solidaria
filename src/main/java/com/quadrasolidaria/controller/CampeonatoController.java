package com.quadrasolidaria.controller;

import com.quadrasolidaria.entity.Campeonato;
import com.quadrasolidaria.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
@CrossOrigin(origins = "*")
@SuppressWarnings("null")
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository repository;

    @GetMapping
    public List<Campeonato> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Campeonato salvar(@RequestBody Campeonato campeonato) {
        return repository.save(campeonato);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }
}