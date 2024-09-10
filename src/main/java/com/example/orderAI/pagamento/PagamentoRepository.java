package com.example.orderAI.pagamento;

import com.example.orderAI.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

    List<Pagamento> findByUsuario(Usuario usuario);
}
