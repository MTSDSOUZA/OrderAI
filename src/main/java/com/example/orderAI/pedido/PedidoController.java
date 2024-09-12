package com.example.orderAI.pedido;

import java.util.List;
import java.util.Optional;

import com.example.orderAI.usuario.Usuario;
import com.example.orderAI.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import static org.springframework.http.HttpStatus.NO_CONTENT;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pedido")
@CacheConfig(cacheNames = "pedidos")
@Slf4j
@Tag(name = "pedido", description = "Gerenciamento de pedidos do usuário")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @Cacheable
    @Operation(summary = "Listar todos os Pedidos")
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }

//    @GetMapping("/usuario/{id_usuario}")
//    @Operation(summary = "Listar todos os Pedidos do usuário")
//    public ResponseEntity<List<Pedido>> findByUsuario(@PathVariable Long id_usuario) {
//        Usuario usuario = usuarioService.getById(id_usuario);
//        List<Pedido> pedidos = pedidoService.findByUsuario(usuario);
//        return ResponseEntity.ok(pedidos);
//    }

    @GetMapping("{id}")
    @Operation(summary = "Listar Pedido por id")
    public ResponseEntity<Pedido> getById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(pedidoService.getById(id)));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CacheEvict(allEntries = true)
    @Operation(summary = "Cadastrar Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400")
    })
    public Pedido create(@RequestBody @Valid Pedido pedido) {
        log.info("Cadastrando pedido: {}", pedido);
        return pedidoService.create(pedido);
    }

    @DeleteMapping("{id_pedido}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(summary = "Deletar Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "401")
    })
    public void delete(@PathVariable Long id_pedido) {
        log.info("Apagando pedido com id {}", id_pedido);
        pedidoService.delete(id_pedido);
    }

    @PutMapping("{id_pedido}")
    @CacheEvict(allEntries = true)
    @Operation(summary = "Atualizar Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "401"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Pedido> update(@PathVariable Long id_pedido, @RequestBody Pedido pedido) {
        log.info("Atualizando pedido com id {} para {}", id_pedido, pedido);
        Pedido updatedPedido = pedidoService.update(id_pedido, pedido);
        return ResponseEntity.ok(updatedPedido);
    }
}
