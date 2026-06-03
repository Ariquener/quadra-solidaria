package com.quadrasolidaria.repository;

import com.quadrasolidaria.entity.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraRepository extends JpaRepository<Quadra, Integer> {

}