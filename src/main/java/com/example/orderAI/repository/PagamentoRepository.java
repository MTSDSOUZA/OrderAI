package com.example.orderAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderAI.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

    
}
