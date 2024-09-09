package com.example.orderAI.itempedido_pedido;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

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
    ItemPedido_PedidoRepository repositoryItemPedido_Pedido;


    @GetMapping
    @Operation(
        summary = "Listar Associação de Pedido e ItemPedido"
    )
    public List<ItemPedido_Pedido> index() {
        return repositoryItemPedido_Pedido.findAll();
    }

    @Operation(
        summary = "Listar associação de Pedido e ItemPedido por id"
    )
    @GetMapping("{id}")
    public ResponseEntity<ItemPedido_Pedido> listarItem(@PathVariable Long id){

        return repositoryItemPedido_Pedido
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
    public ItemPedido_Pedido create(@RequestBody @Valid ItemPedido_Pedido itempedido_pedido) {
        log.info("Cadastrando ItemPedido_Pedido: {}", itempedido_pedido);
        repositoryItemPedido_Pedido.save(itempedido_pedido);
        return itempedido_pedido;
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
    public void destroy(@PathVariable Long id) {
        log.info("Apagando ItemPedido_Pedido");

        verificarSeExisteItem(id);
        repositoryItemPedido_Pedido.deleteById(id);
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
    public ItemPedido_Pedido update(@PathVariable Long id_itemPedido_Pedido, @RequestBody ItemPedido_Pedido item){
        log.info("atualizando ItemPedido_Pedido com id {} para {}", id_itemPedido_Pedido, item);

        verificarSeExisteItem(id_itemPedido_Pedido);
        item.setId_itemPedido_Pedido(id_itemPedido_Pedido);
        return repositoryItemPedido_Pedido.save(item);
    }

    private void verificarSeExisteItem(Long ItemPedido_Pedido) {
        repositoryItemPedido_Pedido
            .findById(ItemPedido_Pedido)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, 
                                "Não existe ItemPedido_Pedido com o id informado."
                            ));
    }
}
