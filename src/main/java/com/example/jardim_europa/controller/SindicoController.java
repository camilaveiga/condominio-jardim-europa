package com.example.jardim_europa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jardim_europa.model.Morador;
import com.example.jardim_europa.model.Sindico;
import com.example.jardim_europa.service.MoradorService;
import com.example.jardim_europa.service.SindicoService;

@RestController
@RequestMapping("/sindico")
public class SindicoController {

    @Autowired
    private SindicoService sindicoService;

    @PostMapping("/cadastrar")
    public Sindico cadastrarSindico(@RequestBody Sindico sindico) {
        return sindicoService.cadastrarSindico(sindico);
    }

    @Autowired
    private MoradorService moradorService;
    
    @GetMapping("/moradores")
    public List<Morador> listarMoradores() {
        return moradorService.listarMoradores();
    }

}
