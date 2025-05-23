import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import projetofaculdade.DadosInvalidosException;
import projetofaculdade.EstoqueInsuficienteException;

public class PessoaFisica extends Cliente {
    private String cpf;
    private List<Compra> compras;

    // Construtor
    public PessoaFisica(String nome, String endereco, long telefone, String cpf) throws DadosInvalidosException {
        super(nome, endereco, telefone, cpf, false);
        setCpf(cpf); // valida e define o CPF
        this.compras = new ArrayList<>();
    }

    // Validação básica de CPF (formato XXX.XXX.XXX-XX ou 11 dígitos)
    private boolean validarCpf(String cpf) {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}";
        return Pattern.matches(regex, cpf);
    }

    // Setter com validação
    public void setCpf(String cpf) throws DadosInvalidosException {
        if (cpf == null || !validarCpf(cpf)) {
            throw new DadosInvalidosException("CPF inválido: " + cpf);
        }
        this.cpf = cpf;
        super.setIdentificador(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void comprarProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade <= 0) {
            throw new EstoqueInsuficienteException("Quantidade deve ser maior que zero.");
        }
        produto.removerEstoque(quantidade);
        compras.add(new Compra(produto, quantidade));
        System.out.println(nome + " comprou " + quantidade + " x " + produto.getNome());
    }

    public void exibirCompras() {
        System.out.println("Histórico de compras de " + nome + ":");
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            for (Compra compra : compras) {
                System.out.println(compra);
            }
        }
    }

    @Override
    protected void atualizar(String nome, String endereco, long telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = String.valueOf(telefone);
    }

    @Override
    protected void exibirCliente() {
        System.out.println("=== Pessoa Física ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}
