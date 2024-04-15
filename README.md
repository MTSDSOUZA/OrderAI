# OrderAI

## Nome da aplicação;

OrderAI

## Nome completo e breve apresentação dos integrantes do Grupo (Atividade da qual ficou responsável no projeto);

Gabriel Augusto Fernandes - RM98986 (DISRUPTIVE ARCHITECTURES: IOT, IOB & GENERATIVE IA | COMPLIANCE, QUALITY ASSURANCE & TESTS)

Kauê Fernandes Braz - RM97768 (ADVANCED BUSINESS DEVELOPMENT WITH .NET | JAVA ADVANCED)

Mariana Trentino Albano - RM551154 (MASTERING RELATIONAL AND NON-RELATIONAL DATABASE)

Matheus Dantas de Sousa - RM98406 (DevOps Tools & Cloud Computing)

Thomas Nícolas de Melo Mendonça - RM99832 (Mobile Application Development)

## Instrução de como rodar a aplicação;

1. Baixar o extension pack do JAVA
2. Ir até o orderAI/src/main/java/com/example/orderAI/OrderAiApplication.java
3. Clicar em Run para rodar a API
4. Pesquisar por localhost:8080
5. Acessar o h2-console para verificar a persistência de dados através da url localhost:8080/h2-console
6. trocar o JDBC URL por jdbc:h2:mem:orderai e conectar
7. Testar as requisições pelo Postman ou Insomnia

## Imagem dos diagramas;

## Link para vídeo apresentando a Proposta Tecnológica, o público-alvo da aplicação e os problemas que a aplicação se propõe a solucionar;

## Listagem de todos os endpoints (Documentação da API);

### Endpoints

- [Cadastrar_Usuario](#cadastrar-usuario)
- [Listar Usuario](#listar-usuario)
- [Atualizar Usuario](#atualizar-usuario)
- [Deletar_Usuario](#deletar-usuario)
- [Realizar Pedido](#realizar-pedido)
- [Listar_Pedido](#listar-pedido)
- [Atualizar Pedido](#atualizar-pedido)
- [Deletar Pedido](#deletar-pedido)
- [Adicionar Item](#adicionar-item)
- [Listar_Items](#listar-items)
- [Remover Item](#remover-item)
- [Realizar Pagamento](#realizar-pagamento)

---

### Cadastrar Usuario

`POST` /usuario

Cadastrar um novo usuário ao acessar a plataforma.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `nome`|string |✅| Nome completo do usuário.
| `email`|string |✅| Email para  login e contato.
| `senha`|string |✅| Senha para acessar a plataforma.
| `telefone`|string |✅| Telefone de contato.
| `endereco`|string |✅| Nome do endereço.
| `cep`|string |✅| CEP do endereço.
| `cidade`|string |✅| Nome da Cidade.
| `estado`|string |✅| Nome do Estado.
| `cpf`|string |✅| CPF da pessoa.
| `data_cadastro`|localdate |✅| Data de Cadastro na plataforma.
| `data_nascimento`|localdate |✅| Data de Nascimento da pessoa.
| `sexo`|string |✅| Gênero da pessoa.

```js
{
    "nome": "Kauê",
    "email": "rm97768@fiap.com.br",
    "senha": "12345678",
    "telefone": "1193241-7895",
    "endereco": "Rua Fiap",
    "cep": "123456789",
    "cidade": "São Paulo",
    "estado": "São Paulo",
    "cpf": "54610446898",
    "data_cadastro": "2022-03-23",
    "data_nascimento": "2005-03-23",
    "sexo": "Masculino"
}
```

#### Exemplo de resposta
```js
{
    "id_usuario": 1,
    "nome": "Kauê",
    "email": "rm97768@fiap.com.br",
    "senha": "12345678",
    "telefone": "1193241-7895",
    "endereco": "Rua Fiap",
    "cep": "123456789",
    "cidade": "São Paulo",
    "estado": "São Paulo",
    "cpf": "54610446898",
    "data_cadastro": "2022-03-23",
    "data_nascimento": "2005-03-23",
    "sexo": "Masculino"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `201`  | Usuário cadastrado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição

---

### Listar Usuario

`GET` /usuario

Retorna um array com todos usuarios.

#### Exemplo de resposta

```js
[
    {
        "id_usuario": 1,
        "nome": "Kauê",
        "email": "kauefernandesbraz@gmail.com",
        "senha": "12345678",
        "telefone": "1193241-9398",
        "endereco": "Rua Isaar Carlos de Camargo",
        "cep": "08280040",
        "cidade": "São Paulo",
        "estado": "São Paulo",
        "cpf": "54610446898",
        "data_cadastro": "2005-03-23",
        "data_nascimento": "2005-03-23",
        "sexo": "Masculino"
    }
]
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Usuarios retornados com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login

---

### Atualizar Usuario

`PUT`/usuario/`{id_usuario}`

Atualizar os dados de usuario com o `id_usuario` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `nome`|string |✅| Nome completo do usuário.
| `email`|string |✅| Email para  login e contato.
| `senha`|string |✅| Senha para acessar a plataforma.
| `telefone`|string |✅| Telefone de contato.
| `endereco`|string |✅| Nome do endereço.
| `cep`|string |✅| CEP do endereço.
| `cidade`|string |✅| Nome da Cidade.
| `estado`|string |✅| Nome do Estado.
| `cpf`|string |✅| CPF da pessoa.
| `data_cadastro`|localdate |✅| Data de Cadastro na plataforma.
| `data_nascimento`|localdate |✅| Data de Nascimento da pessoa.
| `sexo`|string |✅| Gênero da pessoa.
```js
{
    "nome": "Kauê",
    "email": "rm97768@fiap.com.br",
    "senha": "12345678",
    "telefone": "1193241-7895",
    "endereco": "Rua Fiap",
    "cep": "123456789",
    "cidade": "São Paulo",
    "estado": "São Paulo",
    "cpf": "54610446898",
    "data_cadastro": "2022-03-23",
    "data_nascimento": "2005-03-23",
    "sexo": "Masculino"
}
```

#### Exemplo de resposta
```js
{
    "id_usuario": 1,
    "nome": "Kauê",
    "email": "rm97768@fiap.com.br",
    "senha": "12345678",
    "telefone": "1193241-7895",
    "endereco": "Rua Fiap",
    "cep": "123456789",
    "cidade": "São Paulo",
    "estado": "São Paulo",
    "cpf": "54610446898",
    "data_cadastro": "2022-03-23",
    "data_nascimento": "2005-03-23",
    "sexo": "Masculino"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Usuario atualizada com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição
| `401`  | Usuário não autenticado. Realize autenticação em /login
| `404`  | Não existe categoria com o `id_usuario` informado. Consulte a lista em /usuario

---

### Deletar Usuario

`DELETE` /usuario/`{id_usuario}`

Apaga a usuario indicada pelo `id_usuario` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|---     | ---
| `204`  | Usuário apagada com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /login
| `404`  | Não existe usuario com o `id_usuario` informado. Consulte a lista em /usuario

---

### Realizar Pedido

`POST` /pedido

Realizar um novo pedido.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `valor_total`|Double |✅| Valor Total do pedido.
| `frete_entrega`|Double |✅| Frete de entrega do pedido.
| `data_pedido`|LocalDate |✅| Data que o pedido foi realizado.
| `data_entrega`|LocalDate |✅| Data de entrega prevista para o pedido.

```js
{
    "valor_total": "100.00",
    "frete_entrega": "15.00",
    "data_pedido": "2024-04-11",
    "data_entrega": "2024-06-11" //colocar data no futuro
}
```

#### Exemplo de resposta
```js
{
    "id_pedido": 1,
    "valor_total": 100.0,
    "frete_entrega": 15.0,
    "data_pedido": "2024-04-11",
    "data_entrega": "2024-06-11"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `201`  | Pedido realizado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição

---

### Listar Pedido

`GET` /pedido

Retorna um array com todo o pedido.

#### Exemplo de resposta

```js
[
    {
        "id_pedido": 1,
        "valor_total": 100.0,
        "frete_entrega": 15.0,
        "data_pedido": "2024-04-11",
        "data_entrega": "2024-06-11"
    }
]
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Pedidos retornados com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login

---

### Atualizar Pedido

`PUT`/pedido/`{id_pedido}`

Atualizar os dados de pedido com o `id_pedido` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `valor_total`|Double |✅| Valor Total do pedido.
| `frete_entrega`|Double |✅| Frete de entrega do pedido.
| `data_pedido`|LocalDate |✅| Data que o pedido foi realizado.
| `data_entrega`|LocalDate |✅| Data de entrega prevista para o pedido.
```js
{
    "valor_total": "100.00",
    "frete_entrega": "15.00",
    "data_pedido": "2024-04-11",
    "data_entrega": "2024-06-11" //colocar data no futuro
}
```

#### Exemplo de resposta
```js
{
    "id_pedido": 1,
    "valor_total": 100.0,
    "frete_entrega": 15.0,
    "data_pedido": "2024-04-11",
    "data_entrega": "2024-06-11"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Pedido atualizado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição
| `401`  | Usuário não autenticado. Realize autenticação em /login
| `404`  | Não existe pedido com o `id_pedido` informado. Consulte a lista em /pedido

---

### Deletar Pedido

`DELETE` /pedido/`{id_pedido}`

Apaga o pedido indicado pelo `id_pedido` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|---     | ---
| `204`  | Pedido apagado com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /login
| `404`  | Não existe pedido com o `id_pedido` informado. Consulte a lista em /pedido

---

### Adicionar Item

`POST` /item

Adicionar um novo item no pedido.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `nome`|string |✅| Nome do item.
| `descricao`|string |✅| Descrição do item.
| `quantidade`|int |✅| Quantidade do Item.
| `preco`|double |✅| Preço do item.
| `recomendacao`|string |✅| Recomendações de uso/consumo daquele item.

```js
{
    "nome": "ProdutoX",
    "descricao": "Descrição do meu produto",
    "quantidade": "2",
    "preco": "100.00",
    "recomendacao": "Use com moderação"
}
```

#### Exemplo de resposta
```js
{
    "id_itempedido": 1,
    "nome": "ProdutoX",
    "descricao": "Descrição do meu produto",
    "quantidade": 2,
    "preco": 100.0,
    "recomendacao": "Use com moderação"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `201`  | item adicionado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição

---

### Listar Items

`GET` /item

Retorna um array com todo o pedido.

#### Exemplo de resposta

```js
[
    {
        "id_itempedido": 1,
        "nome": "ProdutoX",
        "descricao": "Descrição do meu produto",
        "quantidade": 2,
        "preco": 100.0,
        "recomendacao": "Use com moderação"
    }
]
```

#### Código de Status

| código | descrição
|---     | ---
| `200`  | Items retornados com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /usuario/login

---

### Remover Item

`DELETE` /item/`{id_itempedido}`

Apaga o item indicado pelo `id_itempedido` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|---     | ---
| `204`  | Item apagado com sucesso
| `401`  | Usuário não autenticado. Realize autenticação em /login
| `404`  | Não existe item com o `id_itempedido` informado. Consulte a lista em /item

---

### Realizar Pagamento

`POST` /pagamento

Realizar o pagamento.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|:---:|:---:|:---:|:---:|
| `num_cartao`|string |✅| Número do Cartão.
| `nome_cartao`|string |✅| Nome no cartão.
| `data_validade`|string |✅| Data de validade do Cartão.
| `cvv`|int |✅| Codigo de segurança do Cartão.
| `apelido_cartao`|string |✅| Apelido para identificar o cartão salvo.

```js
{
    "num_cartao": "1234567890123456",
    "nome_cartao": "Kauê Fernandes Braz",
    "data_validade": "12/30",
    "cvv": "123",
    "apelido_cartao": "Cartão de Crédito"
}
```

#### Exemplo de resposta
```js
{
    "id_pagamento": 1,
    "num_cartao": "1234567890123456",
    "nome_cartao": "Kauê Fernandes Braz",
    "data_validade": "12/30",
    "cvv": 123,
    "apelido_cartao": "Cartão de Crédito"
}
```

#### Código de Status

| código | descrição
|---     | ---
| `201`  | pagamento realizado com sucesso
| `400`  | Validação falhou. Verifique as regras para o corpo da requisição



