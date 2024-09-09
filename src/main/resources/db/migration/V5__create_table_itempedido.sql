CREATE TABLE IF NOT EXISTS itempedido (
                            id_itempedido BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao VARCHAR(255) NOT NULL,
                            recomendacao VARCHAR(255) NOT NULL,
                            itempedidopedido_id BIGINT,
                            CONSTRAINT fk_itempedidopedido FOREIGN KEY (itempedidopedido_id) REFERENCES pedido(id_pedido)
);
