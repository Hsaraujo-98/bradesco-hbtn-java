public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        // aplica tarifa e juros como na classe básica
        super.aplicarAtualizacaoMensal();

        // aplica penalidade se saldo estiver abaixo do mínimo
        if (getSaldo() < saldoMinimo) {
            double novoSaldo = getSaldo() - valorPenalidade;
            try {
                // atualiza saldo diretamente
                java.lang.reflect.Field f = ContaBancariaBasica.class.getDeclaredField("saldo");
                f.setAccessible(true);
                f.set(this, novoSaldo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
