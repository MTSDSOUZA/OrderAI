package com.example.orderAI.itempedido_pedido;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import com.example.orderAI.pedido.Pedido;
import com.example.orderAI.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/itempedidopedido")
@Slf4j
@Tag(name = "ItemPedido_Pedido", description = "Faz a associação entre o itemPedido e Pedido")
public class ItemPedido_PedidoController {
    @Autowired
    private ItemPedido_PedidoService itemPedido_pedidoService;

    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    @Operation(
        summary = "Listar Associação de Pedido e ItemPedido"
    )
    public ResponseEntity<List<ItemPedido_Pedido>> findAll() {
        List<ItemPedido_Pedido> itens = itemPedido_pedidoService.findAll();
        return ResponseEntity.ok(itens);
    }

    @Operation(
        summary = "Listar itens de um pedido em específico"
    )
    @GetMapping("/pedido/{id_pedido}")
    public ResponseEntity<List<ItemPedido_Pedido>> findByPedido(@PathVariable Long id_pedido) {
        Pedido pedido = pedidoService.getById(id_pedido);
        List<ItemPedido_Pedido> itens = itemPedido_pedidoService.findByPedido(pedido);
        return ResponseEntity.ok(itens);
    }

    @Operation(
            summary = "Listar associação de Pedido e ItemPedido por id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido_Pedido> getById(@PathVariable Long id) {
        ItemPedido_Pedido item = itemPedido_pedidoService.getById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(
        summary = "Cadastrar associação de pedido e itemPedido"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201"),
        @ApiResponse(responseCode = "400"),
    })
    public ResponseEntity<ItemPedido_Pedido> create(@RequestBody ItemPedido_Pedido itemPedido_pedido) {
        ItemPedido_Pedido newItem = itemPedido_pedidoService.create(itemPedido_pedido);
        return ResponseEntity.ok(newItem);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Deletar associação de pedido e itemPedido"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204"),
        @ApiResponse(responseCode = "404"),
        @ApiResponse(responseCode = "401")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemPedido_pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar associação de pedido e itemPedido"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "401"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<ItemPedido_Pedido> update(@PathVariable Long id, @RequestBody ItemPedido_Pedido itemPedido_pedido) {
        ItemPedido_Pedido updatedItem = itemPedido_pedidoService.update(id, itemPedido_pedido);
        return ResponseEntity.ok(updatedItem);
    }

}
