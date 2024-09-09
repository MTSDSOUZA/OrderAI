package com.example.orderAI.itempedido;

import java.util.List;

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
    ItemPedidoRepository repositoryItemPedido;

    @GetMapping
    @Cacheable
    @Operation(
        summary = "Listar Items"
    )
    public List<ItemPedido> index() {
        return repositoryItemPedido.findAll();
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Listar Item por id"
    )
    public ResponseEntity<ItemPedido> listarItem(@PathVariable Long id){

        return repositoryItemPedido
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
    public ItemPedido create(@RequestBody @Valid ItemPedido item) {
        log.info("Cadastrando Item: {}", item);
        repositoryItemPedido.save(item);
        return item;
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
    public void destroy(@PathVariable Long id_itempedido) {
        log.info("Apagando Item");

        verificarSeExisteItem(id_itempedido);
        repositoryItemPedido.deleteById(id_itempedido);
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
