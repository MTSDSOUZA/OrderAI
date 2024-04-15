package com.example.orderAI.controller;

import java.util.List;
import static org.springframework.http.HttpStatus.NO_CONTENT;
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

import com.example.orderAI.model.Pagamento;
import com.example.orderAI.repository.PagamentoRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pagamento")
@Slf4j
public class PagamentoController {
    @Autowired
    PagamentoRepository repositoryPagamento;

    @GetMapping
    public List<Pagamento> index() {
        return repositoryPagamento.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pagamento create(@RequestBody @Valid Pagamento pagamento) {
        log.info("Cadastrando pagamento: {}", pagamento);
        repositoryPagamento.save(pagamento);
        return pagamento;
    }

    @DeleteMapping("{id_pagamento}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id_pagamento) {
        log.info("Apagando pagamento");

        verificarSeExistePagamento(id_pagamento);
        repositoryPagamento.deleteById(id_pagamento);
    }

    @PutMapping("{id_pagamento}")
    public Pagamento update(@PathVariable Long id_pagamento, @RequestBody Pagamento pagamento){
        log.info("atualizando pagamento com id {} para {}", id_pagamento, pagamento);

        verificarSeExistePagamento(id_pagamento);
        pagamento.setId_pagamento(id_pagamento);
        return repositoryPagamento.save(pagamento);
    }

    private void verificarSeExistePagamento(Long id_pagamento) {
        repositoryPagamento
            .findById(id_pagamento)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, 
                                "Não existe pagamento com o id informado. Consulte lista em /pagamento"
                            ));
    }
}
