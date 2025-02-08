package com.example.jardim_europa.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jardim_europa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}
