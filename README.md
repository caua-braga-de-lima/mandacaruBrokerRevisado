# MandaCaru Broker API

## Descrição
A Mandacaru Broker API é uma aplicação Spring Boot que fornece operações CRUD (Create, Read, Update, Delete) para gerenciar informações sobre ações (stocks).

## Recursos

### Listar Todas as Ações
Retorna uma lista de todas as ações disponíveis.

**Endpoint:**
```http
GET /stocks
```

### Obter uma Ação por ID

Retorna os detalhes de uma ação específica com base no ID.

**Endpoint:**
```http
GET /stocks/{id}
```

### Criar uma Nova Ação
Cria uma nova ação com base nos dados fornecidos.

**Endpoint:**
```http
POST /stocks
```
**Corpo da Solicitação (Request Body):**

**O Campo "symbol" deve ser constituído de 3 letras e 1 número.**
**O campo "companyName" deve receber um dado String e o campo "price" deve receber um valor inteiro**

```JSON
{
  "symbol": "BBAS3", 
  "companyName": "Banco do Brasil SA",
  "price": 56.97
}

```
### Atualizar uma Ação por ID
Atualiza os detalhes de uma ação específica com base no ID.

**Endpoint:**
```http
PUT /stocks/{id}
```
**Corpo da Solicitação (Request Body):**
**O Campo "symbol" deve ser constituído de 3 letras e 1 número.**
**O campo "companyName" deve receber um dado String e o campo "price" deve receber um valor inteiro**

```JSON
{
  "symbol": "BBAS3",
  "companyName": "Banco do Brasil SA",
  "price": 59.97
}

```

### Excluir uma Ação por ID
Exclui uma ação específica com base no ID.

**Endpoint:**
```http
DELETE /stocks/{id}
```


## Uso
1. Clone o repositório: `git clone https://github.com/seu-usuario/MandaCaruBrokerAPI.git`
2. Importe o projeto em sua IDE preferida.
3. Configure o banco de dados e as propriedades de aplicação conforme necessário.
4. Execute o aplicativo Spring Boot.
5. Acesse a API em `http://localhost:8080`.

## Requisitos
- Java 11 ou superior
- Maven
- Banco de dados
- Spring Boot 3.2.1 ou superior

## Tecnologias Utilizadas
- Java 11
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL

## Contribuições
Contribuições são bem-vindas! Segue uma lista do que pode ser feito para melhorar nossa aplicação:
- Adicionar Novos Recursos ou Endpoints
- Aprimorar a Validação de Dados
- Implementar Webhooks ou Notificações
- Otimizar o desempenho da API
- Traduzir a Documentação ou Mensagens de Erro

## Licença
Este projeto está licenciado sob a [Licença MIT](LICENSE).

