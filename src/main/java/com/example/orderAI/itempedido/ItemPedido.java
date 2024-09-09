package com.example.orderAI.itempedido;

import com.example.orderAI.itempedido_pedido.ItemPedido_Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "itempedido")
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itempedido;

    @NotBlank(message = "itempedido.nome.notblank")
    @Size(min = 3, max = 255, message = "itempedido.nome.size")
    private String nome;

    @NotBlank(message = "itempedido.descricao.notblank")
    @Size(min = 3, max = 255, message = "itempedido.descricao.size")
    private String descricao;

    @NotBlank(message = "itempedido.recomendacao.notblank")
    @Size(min = 3, max = 255, message = "itempedido.recomendacao.size")
    private String recomendacao;

    @ManyToOne
    private ItemPedido_Pedido itempedidopedido;
}

