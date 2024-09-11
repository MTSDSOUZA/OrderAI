package com.example.orderAI.itempedido;

import com.example.orderAI.itempedido_pedido.ItemPedido_Pedido;
import com.example.orderAI.itempedido_pedido.ItemPedido_PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;


    // Lista todos os itens de pedido
    public List<ItemPedido> findAll() {
        return repository.findAll();
    }

//    // Lista itens de pedido por ItemPedido_Pedido
//    public List<ItemPedido> findByItemPedido_Pedido(ItemPedido_Pedido itemPedido_Pedido) {
//        return repository.findByItemPedido_Pedido(itemPedido_Pedido);
//    }

    // Busca um item de pedido por ID
    public ItemPedido getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPedido not found with ID: " + id));
    }

    // Cria um novo item de pedido
    public ItemPedido create(ItemPedido itemPedido) {
        return repository.save(itemPedido);
    }

    // Atualiza um item de pedido
    public ItemPedido update(Long id, ItemPedido updatedItemPedido) {
        ItemPedido existingItemPedido = getById(id);
        existingItemPedido.setNome(updatedItemPedido.getNome());
        existingItemPedido.setDescricao(updatedItemPedido.getDescricao());
        existingItemPedido.setRecomendacao(updatedItemPedido.getRecomendacao());
        existingItemPedido.setItempedidopedido(updatedItemPedido.getItempedidopedido());

        return repository.save(existingItemPedido);
    }

    // Deleta um item de pedido
    public void delete(Long id) {
        ItemPedido itemPedido = getById(id);
        repository.delete(itemPedido);
    }
}
