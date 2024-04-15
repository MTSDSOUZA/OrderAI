package com.example.orderAI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NO_CONTENT;
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

import com.example.orderAI.model.ItemPedido;
import com.example.orderAI.repository.ItemPedidoRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemPedidoController {
    @Autowired
    ItemPedidoRepository repositoryItemPedido;

    @GetMapping
    public List<ItemPedido> index() {
        return repositoryItemPedido.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemPedido create(@RequestBody @Valid ItemPedido item) {
        log.info("Cadastrando Item: {}", item);
        repositoryItemPedido.save(item);
        return item;
    }

    @DeleteMapping("{id_itempedido}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id_itempedido) {
        log.info("Apagando Item");

        verificarSeExisteItem(id_itempedido);
        repositoryItemPedido.deleteById(id_itempedido);
    }

    @PutMapping("{id_itempedido}")
    public ItemPedido update(@PathVariable Long id_itempedido, @RequestBody ItemPedido item){
        log.info("atualizando Item com id {} para {}", id_itempedido, item);

        verificarSeExisteItem(id_itempedido);
        item.setId_itempedido(id_itempedido);
        return repositoryItemPedido.save(item);
    }

    private void verificarSeExisteItem(Long id_itempedido) {
        repositoryItemPedido
            .findById(id_itempedido)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, 
                                "Não existe Item com o id informado. Consulte lista em /item"
                            ));
    }
}
