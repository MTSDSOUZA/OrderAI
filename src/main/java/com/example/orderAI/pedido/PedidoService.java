package com.example.orderAI.pedido;

import com.example.orderAI.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido create(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido not found with ID: " + id));
    }

    public Pedido update(Long id, Pedido updatedPedido) {
        Pedido existingPedido = getById(id);
        existingPedido.setValor_total(updatedPedido.getValor_total());
        existingPedido.setFrete_entrega(updatedPedido.getFrete_entrega());
        existingPedido.setData_pedido(updatedPedido.getData_pedido());
        existingPedido.setData_entrega(updatedPedido.getData_entrega());
        existingPedido.setUsuario(updatedPedido.getUsuario());

        return repository.save(existingPedido);
    }

    public void delete(Long id) {
        Pedido pedido = getById(id);
        repository.delete(pedido);
    }

    // Novo método para buscar pedidos por usuário
    public List<Pedido> findByUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }
}