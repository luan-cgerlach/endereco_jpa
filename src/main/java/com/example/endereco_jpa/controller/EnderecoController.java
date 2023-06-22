package com.example.endereco_jpa.controller;

import com.example.endereco_jpa.entity.Endereco;
import com.example.endereco_jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("endereco")
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(endereco));
    }

    @GetMapping("endereco/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id){
        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        if(endereco==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }
    @GetMapping("rua/{rua}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorRua(@PathVariable String rua){
        List<Endereco> enderecos = enderecoService.buscarEnderecoPorRua(rua);
        if(enderecos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(enderecos);
        }
    }

    @GetMapping("cep/{cep}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCep(@PathVariable String cep){
        List<Endereco> enderecos = enderecoService.buscarEnderecoPorCep(cep);
        if(enderecos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(enderecos);
        }
    }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCidade(@PathVariable String cidade) {
        List<Endereco> enderecos = enderecoService.buscarEnderecoPorCidade(cidade);
        if (enderecos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereços não encontrados para a cidade: " + cidade);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(enderecos);
        }
    }

    @GetMapping("enderecos")
    public ResponseEntity<List<Endereco>> buscarEnderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecos());
    }

    @PutMapping("atualizar")
    public ResponseEntity<Endereco> atualizarTime(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizarEndereco(endereco));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> apagarEndereco(@PathVariable Long id) {
        try {
            enderecoService.apagarEndereco(id);
            return ResponseEntity.status(HttpStatus.OK).body("Time com id " + id + " excluído com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
