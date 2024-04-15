package com.example.orderAI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pagamento;

    @NotNull(message = "Número do Cartão é obrigatório")
    @Size(max = 16, message = "Descrição deve ter no máximo 16 caracteres")
    private String num_cartao;

    @NotNull(message = "Nome do Cartão é obrigatório")
    @Size(min = 3,max = 255, message = "Nome do Cartão deve ter pelo menos 3 caracteres")
    private String nome_cartao;

    @NotNull(message = "Data de Validade é obrigatório")
    private String data_validade;

    @Positive(message = "O CVV deve ser positivo")
    @NotNull(message = "O CVV é obrigatório")
    private int cvv;

    private String apelido_cartao;
}
