package com.quadrasolidaria.controller;

import com.quadrasolidaria.entity.Quadra;
import com.quadrasolidaria.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quadras")
@CrossOrigin(origins = "*")
@SuppressWarnings("null")
public class QuadraController {

    @Autowired
    private QuadraRepository repository;

    @GetMapping
    public List<Quadra> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Quadra salvar(@RequestBody Quadra quadra) {
        return repository.save(quadra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quadra> buscarPorId(@PathVariable int id) {
        Optional<Quadra> quadra = repository.findById(id);

        return quadra.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}