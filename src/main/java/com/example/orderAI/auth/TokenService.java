package com.example.orderAI.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.orderAI.usuario.Usuario;
import com.example.orderAI.usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private final UsuarioRepository usuarioRepository;
    Algorithm algorithm = Algorithm.HMAC256("assinatura");

    public TokenService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Token create(Usuario user){
        var expiresAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));

        String token = JWT.create()
                .withIssuer("sphere")
                .withSubject(user.getEmail())
                .withClaim("role", "admin")
                .withExpiresAt(expiresAt)
                .sign(algorithm);

        return new Token(token);
    }

    public Usuario getUserFromToken(String token) {
        var email =JWT.require(algorithm)
                .withIssuer("sphere")
                .build()
                .verify(token)
                .getSubject();

        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
