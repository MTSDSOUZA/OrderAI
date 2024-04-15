package com.example.orderAI.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pedido;

    @NotNull(message = "Valor Total é obrigatório")
    @Positive(message = "O Valor Total deve ser positivo")
    private Double valor_total;

    @NotNull(message = "Frete é obrigatório")
    @Positive(message = "O Frete deve ser positivo")
    private Double frete_entrega;

    @Past
    @NotNull(message = "Data do Pedido é obrigatório")
    private LocalDate data_pedido;

    @Future
    @NotNull(message = "Data de Entrega é obrigatória")
    private LocalDate data_entrega;
}
