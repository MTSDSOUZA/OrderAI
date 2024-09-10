package com.example.orderAI.pagamento;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NO_CONTENT;

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
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pagamento")
@CacheConfig(cacheNames = "pagamentos")
@Slf4j
@Tag(name = "pagamaneto", description = "Forma de pagamento do usuário")
public class PagamentoController {
    @Autowired
    PagamentoService pagamentoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @Cacheable
    @Operation(
        summary = "Listar Pagamento"
    )
    public List<Pagamento> findAll() {
        return pagamentoService.findAll();
    }

    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<List<Pagamento>> findByUsuario(@PathVariable Long id_usuario) {
        Usuario usuario = usuarioService.getById(id_usuario);
        List<Pagamento> pagamentos = pagamentoService.findByUsuario(usuario);
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Listar Pagamento por id"
    )
    public ResponseEntity<Pagamento> getById(@PathVariable Long id){

        return ResponseEntity.of(Optional.ofNullable(pagamentoService.getById(id)));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Cadastrar Pagamento"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "201"),
        @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<Pagamento> create(@RequestBody @Valid Pagamento pagamento, UriComponentsBuilder uriBuilder) {
        log.info("Cadastrando pagamento: {}", pagamento);
        pagamentoService.create(pagamento);

        var uri = uriBuilder
                .path("/pagamento/{id}")
                .buildAndExpand(pagamento.getId_pagamento())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(pagamento);
    }

    @DeleteMapping("{id_pagamento}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Deletar Pagamento"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "204"),
        @ApiResponse(responseCode = "404"),
        @ApiResponse(responseCode = "401")
    })
    public void delete(@PathVariable Long id_pagamento) {
        log.info("Apagando pagamento");
        pagamentoService.delete(id_pagamento);
    }

    @PutMapping("{id_pagamento}")
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Atualizar Pagamento"
    )
    @ApiResponses({ 
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400"),
        @ApiResponse(responseCode = "401"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        log.info("Atualizando pagamento com id {} para {}", id, pagamento);
        Pagamento updatedPagamento = pagamentoService.update(id, pagamento);
        return ResponseEntity.ok(updatedPagamento);
    }

}
