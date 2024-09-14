package com.example.orderAI.itempedido_pedido;

import com.example.orderAI.pedido.Pedido;
import jakarta.persistence.*;
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
@Table(name = "itempedido_pedido")
public class ItemPedido_Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_itemPedido_Pedido;

    @ManyToOne
    @JoinColumn(name = "pedido_id_pedido")
    Pedido pedido;

    @NotNull(message = "itempedido_pedido.quantidade.notnull")
    @Positive(message = "itempedido_pedido.quantidade.positive")
    int quantidade;

    @NotNull(message = "itempedido_pedido.preco.notNull")
    @Positive(message = "itempedido_pedido.preco.positive")
    double preco;
}

