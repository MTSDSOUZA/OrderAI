package com.example.orderAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderAI.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    
}
