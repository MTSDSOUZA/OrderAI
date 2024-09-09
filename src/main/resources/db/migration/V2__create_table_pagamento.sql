CREATE TABLE IF NOT EXISTS pagamento (
                           id_pagamento BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           num_cartao VARCHAR(16) NOT NULL,
                           nome_cartao VARCHAR(255) NOT NULL,
                           data_validade VARCHAR(255) NOT NULL,
                           cvv INT NOT NULL CHECK (cvv > 0),
                           apelido_cartao VARCHAR(255),
                           usuario_id BIGINT,
                           CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id_usuario)
);
