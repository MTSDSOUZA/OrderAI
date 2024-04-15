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
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_itempedido;

    @NotBlank(message = "Nome do Item é obrigatório")
    @Size(min = 3, max = 255, message = "Nome do item deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 3, max = 255, message = "Descrição deve ter pelo menos 3 caracteres")
    private String descricao;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "A quantidade deve ser positiva")
    private int quantidade;
    
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private double preco;

    @NotBlank(message = "Recomendação é obrigatória")
    @Size(min = 3, max = 255, message = "Recomendação deve ter pelo menos 3 caracteres")
    private String recomendacao;
}
