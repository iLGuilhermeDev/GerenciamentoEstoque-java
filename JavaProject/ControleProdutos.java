import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetofaculdade.EstoqueInsuficienteException;

public class ControleProdutos {

    private List<Produto> produtos = new ArrayList<>();

    public void cadastrar() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
            String precoStr = JOptionPane.showInputDialog("Digite o preço do produto:");
            double preco = Double.parseDouble(precoStr);
            String estoqueStr = JOptionPane.showInputDialog("Digite a quantidade em estoque:");
            int estoque = Integer.parseInt(estoqueStr);

            Produto produto = new Produto(nome, preco, estoque);
            produtos.add(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public void listar() {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder("Produtos cadastrados:\n");
        for (Produto p : produtos) {
            sb.append("\nNome: ").append(p.getNome());
            sb.append("\nPreço: R$").append(p.getPreco());
            sb.append("\nQuantidade em Estoque: ").append(p.getQuantidadeEmEstoque());
            sb.append("\n---------------------------");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void realizarCompra() {
        try {
            String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto para compra:");
            Produto produtoEncontrado = null;

            for (Produto p : produtos) {
                if (p.getNome().equalsIgnoreCase(nomeProduto.trim())) {
                    produtoEncontrado = p;
                    break;
                }
            }

            if (produtoEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                return;
            }

            String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade para comprar:");
            int quantidade = Integer.parseInt(quantidadeStr);

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida.");
                return;
            }

            // Para fazer a compra, o cliente precisa ser passado — aqui só atualiza o estoque mesmo
            produtoEncontrado.removerEstoque(quantidade);
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");

        } catch (EstoqueInsuficienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar compra: " + e.getMessage());
        }
    }
}
