package com.example.orderAI.itempedido_pedido;

import com.example.orderAI.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedido_PedidoRepository extends JpaRepository<ItemPedido_Pedido, Long>{
    //List<ItemPedido_Pedido> findByPedido(Pedido pedido);

}
