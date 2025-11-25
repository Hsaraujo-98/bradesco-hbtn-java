import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        quantidadeTransacoes++;
        descontarTarifa();
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        quantidadeTransacoes++;
        descontarTarifa();
    }

    private void descontarTarifa() {
        try {
            java.lang.reflect.Field f = ContaBancariaBasica.class.getDeclaredField("saldo");
            f.setAccessible(true);
            double saldoAtual = (double) f.get(this);
            f.set(this, saldoAtual - 0.10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
