import java.util.List;

public class Consulta {
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> {
                    if (p.getCategoria() == CategoriaProduto.ELETRONICO) {
                        // Aplica 15% de desconto
                        p.setPreco(p.getPreco() * 0.85);
                    }
                    return p;
                })
                .toList();
    }
}
