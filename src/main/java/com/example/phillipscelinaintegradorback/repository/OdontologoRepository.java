package com.example.phillipscelinaintegradorback.repository;

import com.example.phillipscelinaintegradorback.domain.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
