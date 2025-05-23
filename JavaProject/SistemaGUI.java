
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaGUI extends JFrame {
    private ControleClientes controleClientes = new ControleClientes();
    private ControleProdutos controleProdutos = new ControleProdutos();

    public SistemaGUI() {
        setTitle(" Sistema de Controle de Estoque");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza a janela

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(8, 1, 10, 10));

        // Botões
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnRealizarCompra = new JButton("Realizar Compra");
        JButton btnExcluirCliente = new JButton("Excluir Cliente");
        JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
        JButton btnSair = new JButton("Sair");

        // Ações dos botões
        btnCadastrarCliente.addActionListener(e -> controleClientes.cadastrar());
        btnCadastrarProduto.addActionListener(e -> controleProdutos.cadastrar());
        btnListarProdutos.addActionListener(e -> controleProdutos.listar());
        btnRealizarCompra.addActionListener(e -> controleProdutos.realizarCompra());
        btnExcluirCliente.addActionListener(e -> controleClientes.excluir());
        btnAtualizarCliente.addActionListener(e -> controleClientes.atualizar());
        btnSair.addActionListener(e -> System.exit(0));

        // Adicionando os botões ao painel
        painel.add(btnCadastrarCliente);
        painel.add(btnCadastrarProduto);
        painel.add(btnListarProdutos);
        painel.add(btnRealizarCompra);
        painel.add(btnExcluirCliente);
        painel.add(btnAtualizarCliente);
        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }

    // Método principal para iniciar a GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaGUI());
    }
}
