package com.example.jardim_europa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jardim_europa.model.Sindico;
import com.example.jardim_europa.repository.SindicoRepository;

import jakarta.validation.Valid;

@Service
public class SindicoService {

    @Autowired
    private SindicoRepository sindicoRepository;
    
    public Sindico cadastrarSindico(@Valid Sindico sindicoDto) {

        if (!sindicoDto.getCpf().matches("^[0-9]+$")) {
            throw new IllegalArgumentException("O CPF deve conter apenas números");
        }

        if (sindicoDto.getCpf().length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos");
        }

        if (sindicoRepository.count() > 0){
            throw new IllegalArgumentException("Já existe um síndico cadastrado");
        }

        try{
            Sindico sindico = new Sindico();

            sindico.setNome(sindicoDto.getNome());
            sindico.setCpf(sindicoDto.getCpf());
            return sindicoRepository.save(sindico);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao cadastrar síndico");
        }

    }
}
