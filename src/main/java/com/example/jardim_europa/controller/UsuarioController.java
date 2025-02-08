package com.example.jardim_europa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jardim_europa.model.Usuario;
import com.example.jardim_europa.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Map<String, String> request){
        String cpf = request.get("cpf");
        String senha = request.get("senha");
        Long morador_id = Long.parseLong(request.get("morador_id"));
        Long sindico_id = Long.parseLong(request.get("sindico_id"));

        return usuarioService.cadastrarUsuario(cpf, senha, morador_id, sindico_id);
    }
    
}
