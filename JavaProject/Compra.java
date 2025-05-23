public class Compra {
    private Produto produto;
    private int quantidade;

    public Compra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return quantidade + " x " + produto.getNome() + " - R$" + String.format("%.2f", produto.getPreco());
    }
}

