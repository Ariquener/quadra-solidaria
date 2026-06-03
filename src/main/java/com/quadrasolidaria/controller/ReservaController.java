package com.quadrasolidaria.controller;

import com.quadrasolidaria.entity.Reserva;
import com.quadrasolidaria.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @GetMapping
    public List<Reserva> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Reserva reserva) {

        if (reserva.getQuadra() == null || reserva.getQuadra().getIdQuadra() == null) {
            return ResponseEntity.badRequest().body("Quadra não enviada");
        }

        if (reserva.getDataReserva() == null) {
            return ResponseEntity.badRequest().body("Data inválida");
        }

        if (reserva.getHorario() == null) {
            return ResponseEntity.badRequest().body("Horário inválido");
        }

        boolean existe = repository.existsByQuadra_IdQuadraAndDataReservaAndHorario(
                reserva.getQuadra().getIdQuadra(),
                reserva.getDataReserva(),
                reserva.getHorario()
        );

        if (existe) {
            return ResponseEntity.badRequest().body("Horário já reservado!");
        }

        return ResponseEntity.ok(repository.save(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Integer id,
            @RequestBody Reserva reservaAtualizada
    ) {
        return repository.findById(id)
                .<ResponseEntity<?>>map(reserva -> {

                    if (reservaAtualizada.getQuadra() == null || reservaAtualizada.getQuadra().getIdQuadra() == null) {
                        return ResponseEntity.badRequest().body("Quadra não enviada");
                    }

                    if (reservaAtualizada.getDataReserva() == null) {
                        return ResponseEntity.badRequest().body("Data inválida");
                    }

                    if (reservaAtualizada.getHorario() == null) {
                        return ResponseEntity.badRequest().body("Horário inválido");
                    }

                    boolean horarioOcupado = repository
                            .findByDataReservaAndQuadra_IdQuadra(
                                    reservaAtualizada.getDataReserva(),
                                    reservaAtualizada.getQuadra().getIdQuadra()
                            )
                            .stream()
                            .anyMatch(item ->
                                    !item.getIdReserva().equals(id) &&
                                    item.getHorario().equals(reservaAtualizada.getHorario())
                            );

                    if (horarioOcupado) {
                        return ResponseEntity.badRequest().body("Horário já reservado!");
                    }

                    reserva.setNomeUsuario(reservaAtualizada.getNomeUsuario());
                    reserva.setDataReserva(reservaAtualizada.getDataReserva());
                    reserva.setHorario(reservaAtualizada.getHorario());
                    reserva.setQuadra(reservaAtualizada.getQuadra());

                    return ResponseEntity.ok(repository.save(reserva));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("Reserva removida com sucesso");
    }

    @GetMapping("/ocupados")
    public List<String> horariosOcupados(
            @RequestParam LocalDate data,
            @RequestParam Integer quadraId
    ) {
        return repository
                .findByDataReservaAndQuadra_IdQuadra(data, quadraId)
                .stream()
                .map(Reserva::getHorario)
                .filter(h -> h != null)
                .map(h -> h.toString().substring(0, 5))
                .toList();
    }
}