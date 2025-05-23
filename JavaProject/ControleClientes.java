import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControleClientes {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar() {
        String[] opcoes = {"Pessoa Física", "Pessoa Jurídica"};
        int tipo = JOptionPane.showOptionDialog(
            null,
            "Selecione o tipo de cliente:",
            "Tipo de Cliente",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (tipo == JOptionPane.CLOSED_OPTION) {
            return; // Usuário fechou a janela
        }

        try {
            String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço:");
            String telefoneStr = JOptionPane.showInputDialog("Digite o telefone (somente números):");
            long telefone = Long.parseLong(telefoneStr);

            Cliente cliente;

            if (tipo == 0) { // Pessoa Física
                String cpf = JOptionPane.showInputDialog("Digite o CPF:");
                cliente = new PessoaFisica(nome, endereco, telefone, cpf);
            } else { // Pessoa Jurídica
                String cnpj = JOptionPane.showInputDialog("Digite o CNPJ:");
                String razaoSocial = JOptionPane.showInputDialog("Digite a razão social:");
                cliente = new PessoaJuridica(nome, endereco, telefone, cnpj, razaoSocial);
            }

            clientes.add(cliente);
            JOptionPane.showMessageDialog(null, "✅ Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void listar() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n\n");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            sb.append((i+1) + ". Nome: " + c.getNome() + "\n");
            sb.append("   Endereço: " + c.getEndereco() + "\n");
            sb.append("   Telefone: " + c.getTelefone() + "\n");
            sb.append("   Identificador: " + c.getIdentificador() + "\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void excluir() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente para excluir:");
        Cliente clienteParaExcluir = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                clienteParaExcluir = c;
                break;
            }
        }
        if (clienteParaExcluir != null) {
            clientes.remove(clienteParaExcluir);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    public void atualizar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente para atualizar:");
        Cliente clienteParaAtualizar = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                clienteParaAtualizar = c;
                break;
            }
        }

        if (clienteParaAtualizar == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }

        try {
            String novoNome = JOptionPane.showInputDialog("Digite o novo nome:", clienteParaAtualizar.getNome());
            String novoEndereco = JOptionPane.showInputDialog("Digite o novo endereço:", clienteParaAtualizar.getEndereco());
            String telefoneStr = JOptionPane.showInputDialog("Digite o novo telefone (somente números):", clienteParaAtualizar.getTelefone());
            long novoTelefone = Long.parseLong(telefoneStr);

            // O método atualizar é abstrato na sua classe Cliente, então chamamos ele:
            clienteParaAtualizar.atualizar(novoNome, novoEndereco, novoTelefone);

            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        }
    }
}
