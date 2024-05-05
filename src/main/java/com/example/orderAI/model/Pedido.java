package com.example.orderAI.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pedido;

    @NotNull(message = "pedido.valor_total.notNull")
    @Positive(message = "pedido.valor_total.positive")
    private Double valor_total;

    @NotNull(message = "pedido.frete_entrega.notNull")
    @Positive(message = "pedido.frete_entrega.positive")
    private Double frete_entrega;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "pedido.data_pedido.notNull")
    private LocalDate data_pedido;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "pedido.data_entrega.notNull")
    private LocalDate data_entrega;

    @ManyToOne
    private Usuario usuario;
}

