import projetofaculdade.DadosInvalidosException;
import projetofaculdade.EstoqueInsuficienteException;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;

    // Construtor
    public PessoaJuridica(String nome, String endereco, long telefone, String cnpj, String razaoSocial) throws DadosInvalidosException {
        super(nome, endereco, telefone, cnpj, true);
        setCnpj(cnpj); // valida e define o CNPJ
        this.razaoSocial = razaoSocial;
    }

    // Setter com validação básica
    public void setCnpj(String cnpj) throws DadosInvalidosException {
        if (cnpj == null || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14}")) {
            throw new DadosInvalidosException("CNPJ inválido: " + cnpj);
        }
        this.cnpj = cnpj;
        super.setIdentificador(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public void comprarProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade <= 0) {
            throw new EstoqueInsuficienteException("Quantidade deve ser maior que zero.");
        }
        produto.removerEstoque(quantidade);
        System.out.println(razaoSocial + " comprou " + quantidade + " x " + produto.getNome());
    }

    @Override
    protected void atualizar(String nome, String endereco, long telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = String.valueOf(telefone);
    }

    @Override
    protected void exibirCliente() {
        System.out.println("=== Pessoa Jurídica ===");
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}