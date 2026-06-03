package com.quadrasolidaria.repository;

import com.quadrasolidaria.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    boolean existsByQuadra_IdQuadraAndDataReservaAndHorario(
            Integer idQuadra,
            LocalDate dataReserva,
            LocalTime horario
    );

    List<Reserva> findByDataReservaAndQuadra_IdQuadra(
            LocalDate dataReserva,
            Integer idQuadra
    );
}