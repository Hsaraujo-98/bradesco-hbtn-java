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
        // Formata com 2 casas decimais e vírgula como separador, para coincidir com o
        // exemplo:
        String precoFormatado = String.format(java.util.Locale.US, "%.2f", preco).replace('.', ',');
        return String.format("[%d] %s %s R$ %s", codigo, nome, categoria, precoFormatado);
    }
}
