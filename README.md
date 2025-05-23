# 🚚 Sistema de Gestão de Transportadora

Projeto acadêmico desenvolvido para simular o gerenciamento de uma transportadora, com funcionalidades voltadas ao **cadastro e controle de motoristas e clientes**, respeitando as diferenças operacionais entre motoristas de **carro** e de **moto**.

---

## 👥 Desenvolvedores

- Pedro Gabriel dos Santos Barros  
- Gabriel Teixeira Bernardes  
- Rafael de Padua Oliveira  

---

## 🎯 Objetivo

Desenvolver um sistema simples que:

- Cadastre motoristas (carro e moto) com suas particularidades.
- Gerencie clientes com prioridade de atendimento.
- Atribua rotas de entrega adequadas ao tipo de motorista.
- Ofereça uma interface inicial via `JOptionPane`.

---

## 🧱 Estrutura de Classes

### 🔹 `Pessoa_` (classe abstrata)
Classe base para todas as pessoas envolvidas (clientes e motoristas).

**Atributos:**
- `nome` (String)
- `telefone` (String)
- `dataNasc` (Calendar)

---

### 🔸 `Cliente` (herda de `Pessoa_`)
Representa o cliente que contrata o serviço.

**Atributos adicionais:**
- `cnpj` (String)
- `endereco` (String)
- `prioridade` (boolean)

---

### 🔹 `Motorista` (herda de `Pessoa_`)
Classe base para motoristas, com atributos comuns.

**Atributos adicionais:**
- `cpf` (String)
- `cnh` (String)
- `placa` (String)

---

### 🚗 `MotoristaCarro` (herda de `Motorista`)
Motorista designado para grandes distâncias ou cargas maiores.

**Atributos específicos:**
- `rota_designada` (String)
- `capacidade_carga` (double)

**Características:**
- Ideal para múltiplas entregas e longas distâncias.
- Atua fora do perímetro urbano.
- Rotas são pré-definidas.

---

### 🛵 `MotoristaMoto` (herda de `Motorista`)
Motorista focado em entregas rápidas em regiões urbanas.

**Atributos específicos:**
- `entregas_dia` (int)
- `zona_atuacao` (String)

**Características:**
- Alta rotatividade de entregas.
- Atuação limitada a zonas específicas.
- Ideal para entregas locais.

---

## 📋 Menu do Sistema

Interface interativa utilizando `JOptionPane`:

--- MENU PRINCIPAL ---
1 - Cadastrar Motorista
2 - Consultar Motorista
3 - Editar Motorista
4 - Cadastrar Cliente
5 - Consultar Cliente
6 - Editar Cliente
0 - Sair


Cada opção permite executar operações de **CRUD** (Create, Read, Update, Delete) sobre as entidades.

---

## 📦 Possibilidades de Expansão

- 🔍 Integração com **Google Maps API** para cálculo de rotas e distâncias.
- 🖥 Interface gráfica aprimorada com **JavaFX** ou **Swing**.
- 📊 Geração de **relatórios de desempenho** dos motoristas.
- 🗃 Persistência de dados em **banco de dados relacional** (ex: SQLite, MySQL).

---

## 🛠 Tecnologias Utilizadas

- Linguagem: **Java**
- Interface: **JOptionPane**
- Paradigma: **Orientação a Objetos**

---

## 📌 Observações

Este é um projeto didático e modular, pensado para ser facilmente estendido com novas funcionalidades, camadas de persistência e visualizações.

---
