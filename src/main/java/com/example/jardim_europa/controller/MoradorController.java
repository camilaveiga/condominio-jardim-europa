package com.example.jardim_europa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jardim_europa.model.Morador;
import com.example.jardim_europa.service.MoradorService;


@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping("/cadastrar")
    public Morador CadastrarMorador(@RequestBody Morador morador) {
        return moradorService.CadastrarMorador(morador);
    }

    
}
