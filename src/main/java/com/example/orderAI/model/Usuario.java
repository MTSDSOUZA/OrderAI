package com.example.orderAI.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Usuario{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;

    @NotNull
    private String nome;

    @Email
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, max = 255, message = "Senha deve ter pelo menos 8 caracteres")
    private String senha;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone; //não esquecer de criar regex para telefone

    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 8, max = 255, message = "Endereço deve ter pelo menos 8 caracteres")
    private String endereco; 

    @NotBlank(message = "CEP é obrigatório")
    @Size(min = 8, max = 255, message = "CEP deve ter pelo menos 8 caracteres")
    private String cep;

    @NotBlank(message = "Cidade é obrigatório")
    @Size(min = 8, max = 255, message = "Cidade deve ter pelo menos 8 caracteres")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório")
    @Size(min = 8, max = 255, message = "Estado deve ter pelo menos 8 caracteres")
    private String estado;

    @CPF
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Past
    @NotNull(message = "Data de cadastro é obrigatória")
    private LocalDate data_cadastro;
    
    @Past
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate data_nascimento;

    @NotBlank(message = "Sexo é obrigatório")
    private String sexo; //criar validação de feminino e masculino

}
