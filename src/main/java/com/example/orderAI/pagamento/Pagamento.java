package com.example.orderAI.pagamento;

import com.example.orderAI.usuario.Usuario;
import jakarta.persistence.*;
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
@Table(name = "pagamento")
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_pagamento;

    @NotNull(message = "pagamento.num_cartao.notNull")
    @Size(max = 16, message = "pagamento.num_cartao.size")
    String num_cartao;

    @NotNull(message = "pagamento.nome_cartao.notNull")
    @Size(min = 3, max = 255, message = "pagamento.nome_cartao.size")
    String nome_cartao;

    @NotNull(message = "pagamento.data_validade.notNull")
    String data_validade;

    @Positive(message = "pagamento.cvv.positive")
    @NotNull(message = "pagamento.cvv.notNull")
    int cvv;

    String apelido_cartao;

    @ManyToOne
    Usuario usuario;
}


