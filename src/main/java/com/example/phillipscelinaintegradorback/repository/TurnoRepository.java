package com.example.phillipscelinaintegradorback.repository;

import com.example.phillipscelinaintegradorback.domain.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
