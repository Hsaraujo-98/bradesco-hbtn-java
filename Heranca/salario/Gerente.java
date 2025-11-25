public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()){
            double bonusBase = getSalarioFixo() * 0.20;
            double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            double bonusExtra = diferenca * 0.01;
            return bonusBase + bonusExtra;
        }
        return 0.0;
    }
}