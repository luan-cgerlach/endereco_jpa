package com.example.endereco_jpa.service;

import com.example.endereco_jpa.entity.Endereco;
import com.example.endereco_jpa.entity.Usuario;
import com.example.endereco_jpa.repository.EnderecoRepository;
import com.example.endereco_jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    private Usuario x(Usuario usuario){
        if (usuario.getEndereco().getRua().equals("Pelotas")){
            usuario.getEndereco().setCidade("SP");
        }
        return usuario;
    }
}
