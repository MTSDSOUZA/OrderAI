package com.example.orderAI.usuario.dto;

import com.example.orderAI.usuario.Usuario;

public record UsuarioProfileResponse(
        String name,
        String email
) {
    public UsuarioProfileResponse(Usuario user){
        this(user.getNome(), user.getEmail());
    }
}
