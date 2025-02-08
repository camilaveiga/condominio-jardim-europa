package com.example.jardim_europa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jardim_europa.model.Morador;
import com.example.jardim_europa.model.Sindico;
import com.example.jardim_europa.model.Usuario;
import com.example.jardim_europa.repository.MoradorRepository;
import com.example.jardim_europa.repository.SindicoRepository;
import com.example.jardim_europa.repository.UsuarioRepository;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private SindicoRepository sindicoRepository;  

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrarUsuario(String cpf, String senha, Long morador_id, Long sindico_id) {
        
        Usuario usuario = new Usuario();

        usuario.setCpf(cpf);
        usuario.setSenha(passwordEncoder.encode(senha));

        if (morador_id != null) {
           Optional<Morador> morador = moradorRepository.findById(morador_id);
           if(morador.isEmpty()) {
               throw new IllegalArgumentException("Morador não encontrado");
           }
           usuario.setMorador(morador.get());

        } else if (sindico_id != null) {
            Optional<Sindico> sindico = sindicoRepository.findById(sindico_id);
            if(sindico.isEmpty()) {
                throw new IllegalArgumentException("Sindico não encontrado");
            }
            usuario.setSindico(sindico.get());
        } else {
            throw new IllegalArgumentException("Morador ou Sindico não informado");
        }
        
        return usuarioRepository.save(usuario);
    
    }
}
