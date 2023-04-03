package com.example.phillipscelinaintegradorback.repository;

import com.example.phillipscelinaintegradorback.domain.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
