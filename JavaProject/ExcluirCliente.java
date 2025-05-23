import java.util.List;
import java.util.Scanner;

public class ExcluirCliente {

    public static void excluirCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF ou CNPJ do cliente que deseja excluir:");
        String documento = scanner.nextLine().trim();

        Cliente clienteParaRemover = null;

        // Buscar cliente correspondente
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) cliente;
                if (pf.getCpf().equalsIgnoreCase(documento)) {
                    clienteParaRemover = cliente;
                    break;
                }
            } else if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) cliente;
                if (pj.getCnpj().equalsIgnoreCase(documento)) {
                    clienteParaRemover = cliente;
                    break;
                }
            }
        }

        if (clienteParaRemover == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            clientes.remove(clienteParaRemover);
            System.out.println("Cliente removido com sucesso.");
        }
    }
}