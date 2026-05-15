# 🛒 Sistema de Controle de Estoque e Clientes

Este é um sistema desenvolvido em **Java** com interface gráfica (Swing) para gerenciar clientes (Pessoa Física e Jurídica), produtos e compras. Ele permite cadastrar, listar, atualizar e excluir clientes, gerenciar estoque de produtos e registrar compras com validação de CPF/CNPJ e estoque insuficiente.

## 🚀 Funcionalidades

- **Clientes**
  - Cadastro de Pessoa Física (CPF) e Jurídica (CNPJ + Razão Social)
  - Listagem de clientes cadastrados
  - Atualização de dados (nome, endereço, telefone)
  - Exclusão de clientes pelo nome

- **Produtos**
  - Cadastro de produtos (nome, preço, quantidade em estoque)
  - Listagem de todos os produtos
  - Realização de compras (reduz estoque automaticamente)

- **Interface Gráfica**
  - Janela principal com botões para todas as operações
  - Mensagens de erro/sucesso via `JOptionPane`
  - Tratamento de exceções (`EstoqueInsuficienteException`, `DadosInvalidosException`)

## 🧱 Estrutura do Projeto
├── Cliente.java # Classe abstrata base para clientes
├── PessoaFisica.java # Cliente PF (herda Cliente)
├── PessoaJuridica.java # Cliente PJ (herda Cliente)
├── Produto.java # Entidade produto com estoque
├── Compra.java # Representa uma compra (produto + quantidade)
├── ControleClientes.java # Lógica de cadastro, listagem, atualização e exclusão de clientes (GUI)
├── ControleProdutos.java # Lógica de cadastro, listagem e compra de produtos (GUI)
├── SistemaGUI.java # Janela principal Swing (entry point gráfico)
├── Main.java # Entry point alternativo (console + GUI – pode ser simplificado)
├── ExcluirCliente.java # [Não utilizado] Exclusão por CPF/CNPJ via console
├── projetofaculdade/ # Pacote de exceções personalizadas
│ ├── DadosInvalidosException.java
│ └── EstoqueInsuficienteException.java

text

> ℹ️ **Nota:** As classes `Main` e `ExcluirCliente` contêm código para testes em console, mas o sistema principal funciona inteiramente pela interface gráfica (`SistemaGUI`).

## 🧪 Pré‑requisitos

- **Java Development Kit (JDK)** 8 ou superior
- Nenhuma dependência externa (bibliotecas padrão Java)

## ▶️ Como executar

1. **Clone ou baixe** todos os arquivos `.java` mantendo a estrutura de diretórios (crie a pasta `projetofaculdade` para as exceções).

2. **Compile todos os arquivos** (a partir do diretório raiz do projeto):
   ```bash
   javac *.java projetofaculdade/*.java
Execute a interface gráfica:

bash
java SistemaGUI
Caso prefira executar a versão de teste (console + GUI), use:

bash
java Main
Porém, a experiência completa é com SistemaGUI.

📋 Exemplo de Uso
Cadastrar Cliente → escolha PF ou PJ, informe os dados solicitados.

Cadastrar Produto → nome, preço e quantidade inicial.

Realizar Compra → informe o nome do produto e a quantidade. O estoque será reduzido automaticamente.

Listar Produtos → exibe todos os produtos com seus preços e estoque atual.

Atualizar/Excluir Cliente → informe o nome do cliente para modificar ou remover.

