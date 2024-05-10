package com.example.orderAI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
public class ItemPedido_Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itemPedido_Pedido;

    @ManyToOne
    private Pedido pedido;

    @NotNull(message="itempedido_pedido.quantidade.notnull")
    @Positive(message="itempedido_pedido.quantidade.positive")
    private int quantidade;

    @NotNull(message="itempedido_pedido.preco.notNull")
    @Positive(message="itempedido_pedido.preco.positive")
    private double preco;

}
