package com.example.orderAI.itempedido;

import com.example.orderAI.itempedido_pedido.ItemPedido_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

//    List<ItemPedido> findByItemPedido_Pedido(ItemPedido_Pedido itemPedido_Pedido);

}
