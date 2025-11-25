import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itensPedido;

    public Pedido(double percentualDesconto, ItemPedido[] itensPedido) {
        this.percentualDesconto = percentualDesconto;
        this.itensPedido = itensPedido;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itensPedido) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        total -= total * (percentualDesconto / 100.0);
        return total;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itensPedido) {
            produtos.Produto produto = item.getProduto();
            String tipo = produto instanceof produtos.Livro ? "Livro" : "Dvd";
            String titulo = produto.getTitulo();
            double preco = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, titulo, preco, quantidade, totalItem);

            totalProdutos += totalItem;
        }

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - desconto;

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }
}
