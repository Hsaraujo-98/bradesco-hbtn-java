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
}
