package com.example.jardim_europa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jardim_europa.model.Morador;
import com.example.jardim_europa.repository.MoradorRepository;

import jakarta.validation.Valid;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository repository;

    public Morador CadastrarMorador(@Valid Morador moradorDto) {

        if (repository.findByCpf(moradorDto.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Morador já cadastrado");
        }

        if (!moradorDto.getCpf().matches("^[0-9]+$")) {
            throw new IllegalArgumentException("O CPF deve conter apenas números");
        }

        if (moradorDto.getCpf().length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos");
        }

        if (moradorDto.getNumeroApto() < 1 || moradorDto.getNumeroApto() > 74) {
            throw new IllegalArgumentException("O número do apartamento deve ser maior que 0 e menor ou igual a 74");
        }

        if (moradorDto.getBloco() < 1 || moradorDto.getBloco() > 5) {
            throw new IllegalArgumentException("O número do bloco deve ser maior que 0 e menor ou igual a 5");
        }


        try {
            Morador morador = new Morador();
            
            morador.setNome(moradorDto.getNome());
            morador.setCpf(moradorDto.getCpf());
            morador.setNumeroApto(moradorDto.getNumeroApto());
            morador.setBloco(moradorDto.getBloco());
            return repository.save(morador);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao cadastrar morador");
        }
    }

    public List<Morador> listarMoradores() {
        return repository.findAll();
    }

    
}
