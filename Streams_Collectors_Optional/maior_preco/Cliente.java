public class Cliente {
    private int codigo;
    private String nome;
    private boolean premium;

    public Cliente(int codigo, String nome, boolean premium) {
        this.codigo = codigo;
        this.nome = nome;
        this.premium = premium;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    // Getter boolean com prefixo "is", conforme solicitado
    public boolean isPremium() {
        return premium;
    }
}
