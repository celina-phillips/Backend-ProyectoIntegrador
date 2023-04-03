package com.example.phillipscelinaintegradorback.repository;

import com.example.phillipscelinaintegradorback.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
