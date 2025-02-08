package com.example.jardim_europa.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jardim_europa.model.Sindico;

public interface SindicoRepository extends JpaRepository<Sindico, Long> {
    Optional<Sindico> findByCpf(String cpf);
}
