CREATE TABLE IF NOT EXISTS itempedido_pedido (
                                   id_itemPedido_Pedido BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                   pedido_id BIGINT,
                                   quantidade INT NOT NULL CHECK (quantidade > 0),
                                   preco DOUBLE NOT NULL CHECK (preco > 0),
                                   CONSTRAINT fk_itempedido_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id_pedido)
);
