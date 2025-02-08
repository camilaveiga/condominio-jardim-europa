package com.example.jardim_europa.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jardim_europa.model.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
    Optional<Morador> findByCpf(String cpf);
}