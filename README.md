# Estudos – PicPay Backend

## 🔹 Visão Geral

Este projeto é um **projeto de estudos**, inspirado no **desafio de backend da empresa PicPay**, originalmente criado por [Giuliana Bezerra](https://github.com/giuliana-bezerra/picpay-desafio-backend).
O objetivo deste estudo é compreender **como estruturar uma aplicação Java utilizando Spring Boot**, aplicando conceitos de organização de código, separação de responsabilidades e boas práticas em arquitetura de software.

> ⚠️ Créditos do desafio original: Giuliana Bezerra
> 🧑‍💻 Autor desta versão: aprendiz de Java, com melhorias e ajustes adicionados para estudo.

---

## 🔹 Objetivos do Projeto

1. Estudar a **estrutura de um backend organizado por domínio**, observando a separação de camadas e responsabilidades.
2. Analisar e reproduzir padrões de **design de software** aplicados em cenários reais de empresas de tecnologia financeira.
3. Implementar endpoints, modelos e serviços seguindo a lógica do projeto de referência, com **melhorias adicionais** para aprendizado.

---

## 🔹 Executando o Projeto

Como os endpoints originais do desafio foram desativados, **simulamos os serviços usando `json-server`**.
Antes de testar o sistema, é necessário subir a API fake executando:

```bash
npm start
```

dentro da pasta `api-picpay-fake`.

Para subir o ambiente com Kafka via Docker Compose:

```bash
docker compose up
```

Em seguida, rode o projeto executando a classe `PicpayApplication`.

---

## 🔹 Referência

O projeto de referência está disponível em:
[https://github.com/giuliana-bezerra/picpay-desafio-backend](https://github.com/giuliana-bezerra/picpay-desafio-backend)

O projeto original demonstra:

* Estrutura de pacotes e módulos organizados por domínio (`wallet`, `transaction`, `user`, etc.)
* Uso de **Spring Boot** e **Spring Data JDBC**
* Boas práticas de tratamento de erros, versionamento de dados e controle de concorrência

---

## 🔹 Diferenciais Adicionados

Nesta versão de estudo, foram realizadas melhorias em relação ao projeto original:

* **Exceções personalizadas** para cada tipo de erro, como:

    * Saldo insuficiente
    * Falha interna do sistema
    * Mensagens de erro mais detalhadas para facilitar o debug
* Ajustes na estrutura de código para **maior clareza e modularidade**

---

## 🔹 Estrutura do Projeto

A organização por domínio segue um padrão **modular**, onde cada módulo contém:

```
src/main/java/com/backend/desafio/picpay/
│
├── wallet/               # Domínio Wallet (Carteira)
│   ├── Wallet.java       # Modelo
│   ├── WalletRepository.java
│   └── WalletService.java
│
├── transaction/          # Domínio Transações
│   ├── Transaction.java
│   ├── TransactionRepository.java
│   └── TransactionService.java
│
├── user/                 # Domínio Usuário
│   ├── User.java
│   ├── UserRepository.java
│   └── UserService.java
│
├── controller/           # Controllers REST
├── dto/                  # Objetos de transferência de dados
└── exception/            # Tratamento de exceções
```

---

## 🔹 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3+**
* **Spring Data JDBC**
* **H2 Database** (para testes em memória)
* **Maven** como gerenciador de dependências
* **Kafka** como sistema de mensagens

---

## 🔹 Conceitos Explorados

* **Organização por domínio**: separação clara de pacotes e responsabilidades.
* **Repositórios e Serviços**: abstração da camada de persistência e regras de negócio.
* **Controle de concorrência**: uso de `@Version` e bloqueio otimista para garantir consistência de dados.
* **Testes de integração**: endpoints e serviços validados usando H2.

---

## 🔹 Objetivo de Aprendizado

1. Entender **como estruturar um backend por domínio** de forma escalável.
2. Aplicar boas práticas de **persistência de dados e serviços**.
3. Implementar **controle de concorrência e transações** em Spring Boot.
4. Familiarizar-se com padrões de projeto usados em empresas de tecnologia financeira.


