package com.example.orderAI.pedido;

import com.example.orderAI.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    List<Pedido> findByUsuario(Usuario usuario);
    
}
