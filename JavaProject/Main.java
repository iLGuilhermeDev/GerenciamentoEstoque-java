import java.util.ArrayList;
import java.util.List;
import projetofaculdade.DadosInvalidosException;
import projetofaculdade.EstoqueInsuficienteException;



public class Main {
    public static void main(String[] args) {
         SistemaGUI.main(args);

        List<Cliente> Cliente = new ArrayList<>();
        try {
            // Criando clientes
            PessoaFisica clientePF = new PessoaFisica("Lucas Silva", "Rua A, 123", 11999999999L, "123.456.789-00");
            PessoaJuridica clientePJ = new PessoaJuridica("Empresa XYZ", "Av. B, 456", 11333333333L, "12.345.678/0001-99", "Empresa XYZ LTDA");

            // Exibindo dados dos clientes
            System.out.println("=== Clientes Criados ===");
            clientePF.exibirCliente();
            System.out.println();
            clientePJ.exibirCliente();
            System.out.println();

            // Criando produtos
            Produto produto1 = new Produto("Teclado Mecânico Razer", 350.0, 10);
            Produto produto2 = new Produto("Mouse Gamer Logitech", 150.0, 5);

            // Exibindo produtos
            System.out.println("=== Produtos Criados ===");
            produto1.exibirProduto();
            System.out.println();
            produto2.exibirProduto();
            System.out.println();

            // Atualizando cliente PF
            clientePF.atualizar("Lucas Atualizado", "Rua Nova, 999", 11888888888L);
            System.out.println("--- Cliente PF atualizado ---");
            clientePF.exibirCliente();
            System.out.println();

            // Cliente PF compra 3 teclados
            System.out.println("Cliente PF comprando 3 teclados...");
            clientePF.comprarProduto(produto1, 3);
            System.out.println();

            // Cliente PJ compra 6 mouses (estoque só tem 5, deve lançar exceção)
            System.out.println("Cliente PJ tentando comprar 6 mouses...");
            clientePJ.comprarProduto(produto2, 6); // Deve lançar exceção

        } catch (EstoqueInsuficienteException | DadosInvalidosException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
