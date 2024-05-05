package com.example.orderAI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pagamento;

    @NotNull(message = "pagamento.num_cartao.notNull")
    @Size(max = 16, message = "pagamento.num_cartao.size")
    private String num_cartao;

    @NotNull(message = "pagamento.nome_cartao.notNull")
    @Size(min = 3, max = 255, message = "pagamento.nome_cartao.size")
    private String nome_cartao;

    @NotNull(message = "pagamento.data_validade.notNull")
    private String data_validade;

    @Positive(message = "pagamento.cvv.positive")
    @NotNull(message = "pagamento.cvv.notNull")
    private int cvv;

    private String apelido_cartao;

    @ManyToOne
    private Usuario usuario;
}

