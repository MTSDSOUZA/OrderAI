CREATE TABLE IF NOT EXISTS pedido (
                        id_pedido BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        valor_total DOUBLE NOT NULL CHECK (valor_total > 0),
                        frete_entrega DOUBLE NOT NULL CHECK (frete_entrega > 0),
                        data_pedido DATE NOT NULL,
                        data_entrega DATE NOT NULL,
                        usuario_id_usuario BIGINT,
                        CONSTRAINT fk_pedido_usuario FOREIGN KEY (usuario_id_usuario) REFERENCES usuario(id_usuario)
);
