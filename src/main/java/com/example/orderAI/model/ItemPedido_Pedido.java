package com.example.orderAI.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemPedido_Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itemPedido_Pedido;

    @ManyToOne
    private Pedido pedido;

    @NotNull(message="")
    @Positive(message="")
    private int quantidade;

    @NotNull(message="")
    @Positive(message="")
    private double preco;

}
