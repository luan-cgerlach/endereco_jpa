package com.example.endereco_jpa.controller;

import com.example.endereco_jpa.entity.Endereco;
import com.example.endereco_jpa.entity.Usuario;
import com.example.endereco_jpa.service.EnderecoService;
import com.example.endereco_jpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("usuario")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuario));
    }
}
