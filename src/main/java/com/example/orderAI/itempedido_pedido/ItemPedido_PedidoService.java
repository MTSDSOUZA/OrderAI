package com.example.orderAI.itempedido_pedido;

import com.example.orderAI.pedido.Pedido;
import com.example.orderAI.pedido.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedido_PedidoService {

    @Autowired
    private ItemPedido_PedidoRepository repository;

    @Autowired
    private PedidoService pedidoService;

    // Lista todos os itens de pedido
    public List<ItemPedido_Pedido> findAll() {
        return repository.findAll();
    }

    // Lista todos os itens de um pedido específico
    public List<ItemPedido_Pedido> findByPedido(Pedido pedido) {
        return repository.findByPedido(pedido);
    }

    // Busca um item específico pelo ID
    public ItemPedido_Pedido getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPedido_Pedido not found with ID: " + id));
    }

    // Cria um novo item de pedido
    public ItemPedido_Pedido create(ItemPedido_Pedido itemPedido_pedido) {
        return repository.save(itemPedido_pedido);
    }

    // Atualiza um item de pedido
    public ItemPedido_Pedido update(Long id, ItemPedido_Pedido updatedItemPedido_Pedido) {
        ItemPedido_Pedido existingItem = getById(id);
        existingItem.setQuantidade(updatedItemPedido_Pedido.getQuantidade());
        existingItem.setPreco(updatedItemPedido_Pedido.getPreco());
        return repository.save(existingItem);
    }

    // Deleta um item de pedido
    public void delete(Long id) {
        ItemPedido_Pedido itemPedido_pedido = getById(id);
        repository.delete(itemPedido_pedido);
    }
}
