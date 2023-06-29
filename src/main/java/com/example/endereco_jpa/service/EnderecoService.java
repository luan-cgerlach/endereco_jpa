package com.example.endereco_jpa.service;

import com.example.endereco_jpa.entity.Endereco;
import com.example.endereco_jpa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarEnderecoPorId(Long id){
        return enderecoRepository.findById(id).get();
    }

    public List<Endereco> buscarEnderecoPorCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    public List<Endereco> buscarEnderecoPorCep(String cep) {
        return enderecoRepository.findAllByCep(cep);
    }

    public List<Endereco> buscarEnderecoPorRua(String rua) {
        return enderecoRepository.findAllByRua(rua);
    }

    public List<Endereco> buscarEnderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void apagarEndereco(Long id){
        if(enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }
}
