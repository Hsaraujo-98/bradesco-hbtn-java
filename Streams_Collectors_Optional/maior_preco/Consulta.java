import java.util.Comparator;
import java.util.List;

public class Consulta {
    // Mantém o método anterior caso seja útil em outros exercícios
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos()
                     .stream()
                     .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                     .toList();
    }

    // Novo método: retorna o produto com maior preço da lista
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                       .sorted(Comparator.comparing(Produto::getPreco).reversed())
                       .findFirst()
                       .orElse(null);
    }
}
