public class Produto {
    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        // Mantém o formato com vírgula para coincidir com a saída esperada
        String precoFormatado = String.format(java.util.Locale.US, "%.2f", preco).replace('.', ',');
        return String.format("[%d] %s %s R$ %s", codigo, nome, categoria, precoFormatado);
    }
}
