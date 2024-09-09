CREATE TABLE IF NOT EXISTS usuario (
                         id_usuario BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255),
                         senha VARCHAR(255) NOT NULL,
                         telefone VARCHAR(255) NOT NULL,
                         endereco VARCHAR(255) NOT NULL,
                         cep VARCHAR(255) NOT NULL,
                         cidade VARCHAR(255) NOT NULL,
                         estado VARCHAR(255) NOT NULL,
                         cpf VARCHAR(11) NOT NULL,
                         data_cadastro DATE NOT NULL,
                         data_nascimento DATE NOT NULL,
                         tipo_pagamento VARCHAR(255),
                         sexo VARCHAR(255)
);
