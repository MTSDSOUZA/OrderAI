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
public class Usuario{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;

    @NotNull
    private String nome;

    @Email
    private String email;

    @NotBlank(message = "{usuario.senha.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.senha.size}")
    private String senha;

    @NotBlank(message = "{usuario.telefone.notblank}")
    private String telefone;

    @NotBlank(message = "{usuario.endereco.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.endereco.size}")
    private String endereco; 

    @NotBlank(message = "{usuario.cep.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.cep.size}")
    private String cep;

    @NotBlank(message = "{usuario.cidade.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.cidade.size}")
    private String cidade;

    @NotBlank(message = "{usuario.estado.notblank}")
    @Size(min = 8, max = 255, message = "{usuario.estado.size}")
    private String estado;

    @CPF
    @NotBlank(message = "{usuario.cpf.notblank}")
    private String cpf;

    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{usuario.datacadastro.notnull}")
    private LocalDate data_cadastro;
    
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{usuario.datanascimento.notnull}")
    private LocalDate data_nascimento;

    @TipoPagamento
    private String tipo_pagamento;
    
    @TipoSexo
    private String sexo;

}
