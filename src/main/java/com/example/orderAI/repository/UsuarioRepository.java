package com.example.orderAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.orderAI.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
