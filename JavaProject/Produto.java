
import projetofaculdade.EstoqueInsuficienteException;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    // Construtor
    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Método para alterar os dados do produto
    public void alterarDados(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Adicionar quantidade ao estoque
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmEstoque += quantidade;
            System.out.println("Estoque atualizado. Quantidade em estoque: " + this.quantidadeEmEstoque);
        } else {
            System.out.println("Quantidade inválida para adicionar.");
        }
    }

    // Remover quantidade do estoque
    public void removerEstoque(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para remoção.");
            return;
        }

        if (quantidade > this.quantidadeEmEstoque) {
            throw new EstoqueInsuficienteException("Erro: Não há estoque suficiente para a venda!");
        }

        this.quantidadeEmEstoque -= quantidade;
        System.out.println("Estoque atualizado. Quantidade em estoque: " + this.quantidadeEmEstoque);
    }

    // Excluir o produto (reseta os dados)
    public void excluir() {
        this.nome = null;
        this.preco = 0;
        this.quantidadeEmEstoque = 0;
        System.out.println("Produto excluído.");
    }

    // Exibir os dados do produto
    public void exibirProduto() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
}
