package com.example.orderAI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itempedido;

    @NotBlank(message = "itempedido.nome.notblank")
    @Size(min = 3, max = 255, message = "itempedido.nome.size")
    private String nome;

    @NotBlank(message = "itempedido.descricao.notblank")
    @Size(min = 3, max = 255, message = "itempedido.descricao.size")
    private String descricao;

    @NotNull(message = "itempedido.quantidade.notNull")
    @Positive(message = "itempedido.quantidade.positive")
    private int quantidade;
    
    @NotNull(message = "itempedido.preco.notNull")
    @Positive(message = "itempedido.preco.positive")
    private double preco;

    @NotBlank(message = "itempedido.recomendacao.notblank")
    @Size(min = 3, max = 255, message = "itempedido.recomendacao.size")
    private String recomendacao;

    @ManyToOne
    private Pedido pedido;
}

