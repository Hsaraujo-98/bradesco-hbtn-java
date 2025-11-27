import java.util.List;

public class Consulta {
    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> p.getProdutos()
                        .stream()
                        .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
                .toList();
    }
}
