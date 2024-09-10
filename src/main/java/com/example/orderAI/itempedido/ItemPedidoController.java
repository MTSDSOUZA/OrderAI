package com.example.orderAI.itempedido;

import java.util.List;

import com.example.orderAI.itempedido_pedido.ItemPedido_Pedido;
import com.example.orderAI.itempedido_pedido.ItemPedido_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/item")
@CacheConfig(cacheNames = "items")
@Slf4j
@Tag(name = "itemPedido", description = "Item que pode ser inserido no pedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private ItemPedido_PedidoService itemPedido_PedidoService;

    @GetMapping
    @Cacheable
    @Operation(
        summary = "Listar Items"
    )
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itens = itemPedidoService.findAll();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/itempedido_pedido/{id_itempedido_pedido}")
    public ResponseEntity<List<ItemPedido>> findByItemPedido_Pedido(@PathVariable Long id_itempedido_pedido) {
        ItemPedido_Pedido itemPedido_Pedido = itemPedido_PedidoService.getById(id_itempedido_pedido);
        List<ItemPedido> itens = itemPedidoService.findByItemPedido_Pedido(itemPedido_Pedido);
        return ResponseEntity.ok(itens);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Listar Item por id"
    )
    public ResponseEntity<ItemPedido> getById(@PathVariable Long id) {
        ItemPedido itemPedido = itemPedidoService.getById(id);
        return ResponseEntity.ok(itemPedido);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Cadastrar Item"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "201"),
        @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<ItemPedido> create(@RequestBody ItemPedido itemPedido) {
        ItemPedido newItem = itemPedidoService.create(itemPedido);
        return ResponseEntity.ok(newItem);
    }

    @DeleteMapping("{id_itempedido}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Deletar Item"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "204"),
        @ApiResponse(responseCode = "404"),
        @ApiResponse(responseCode = "401")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id_itempedido}")
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Atualizar Item"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "401"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<ItemPedido> update(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        ItemPedido updatedItem = itemPedidoService.update(id, itemPedido);
        return ResponseEntity.ok(updatedItem);
    }
}
