package com.example.orderAI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import com.example.orderAI.model.Pedido;
import com.example.orderAI.repository.PedidoRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pedido")
@Slf4j
public class PedidoController {
    @Autowired
    PedidoRepository repositoryPedido;

    @GetMapping
    public List<Pedido> index() {
        return repositoryPedido.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pedido create(@RequestBody @Valid Pedido pedido) {
        log.info("Cadastrando pedido: {}", pedido);
        repositoryPedido.save(pedido);
        return pedido;
    }

    @DeleteMapping("{id_pedido}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id_pedido) {
        log.info("Apagando pedido");

        verificarSeExistePedido(id_pedido);
        repositoryPedido.deleteById(id_pedido);
    }

    @PutMapping("{id_pedido}")
    public Pedido update(@PathVariable Long id_pedido, @RequestBody Pedido pedido){
        log.info("atualizando pedido com id {} para {}", id_pedido, pedido);

        verificarSeExistePedido(id_pedido);
        pedido.setId_pedido(id_pedido);
        return repositoryPedido.save(pedido);
    }

    private void verificarSeExistePedido(Long id_pedido) {
        repositoryPedido
            .findById(id_pedido)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, 
                                "Não existe pedido com o id informado. Consulte lista em /pedido"
                            ));
    }
}
