
import projetofaculdade.EstoqueInsuficienteException;

public abstract class Cliente {
    protected String nome;
    protected String telefone;
    protected String endereco;
    protected String identificador; // Pode ser CPF ou CNPJ

    // Construtor usado pelas subclasses
    public Cliente(String nome, String endereco, long telefone, String identificador, boolean isPJ) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = String.valueOf(telefone);
        this.identificador = identificador;
    }

    // Método abstrato para compra de produto
    public abstract void comprarProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException;

    // Getters e Setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    // Métodos abstratos para atualização de dados e exibição
    protected abstract void atualizar(String nome, String endereco, long telefone);

    protected abstract void exibirCliente();
}

