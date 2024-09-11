package com.example.orderAI.usuario;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import com.example.orderAI.validation.TipoPagamento;
import com.example.orderAI.validation.TipoSexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_usuario;

    @NotNull
    String nome;

    @Email
    String email;

    @NotBlank(message = "{usuario.senha.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.senha.size}")
    String senha;

    @NotBlank(message = "{usuario.telefone.notblank}")
    String telefone;

    @NotBlank(message = "{usuario.endereco.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.endereco.size}")
    String endereco;

    @NotBlank(message = "{usuario.cep.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.cep.size}")
    String cep;

    @NotBlank(message = "{usuario.cidade.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.cidade.size}")
    String cidade;

    @NotBlank(message = "{usuario.estado.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.estado.size}")
    String estado;

    @CPF
    @NotBlank(message = "{usuario.cpf.notblank}")
    String cpf;

    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{usuario.datacadastro.notnull}")
    LocalDate data_cadastro;

    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{usuario.datanascimento.notnull}")
    LocalDate data_nascimento;

    @TipoPagamento
    String tipo_pagamento;

    @TipoSexo
    String sexo;
}

