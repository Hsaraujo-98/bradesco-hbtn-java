import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        Comida comida1 = new Comida("arroz", 100, 15.9);
        Comida comida2 = new Comida("feijao", 80, 23.0);
        Comida comida3 = new Comida("pacoca", 165, 7.5);

        Eletronico eletronico1 = new Eletronico("Smart TV LED 32 HD LG", 1452.55);
        Eletronico eletronico2 = new Eletronico("Nintendo Switch", 2990);

        ArmazemDeEletronico armazem1 = new ArmazemDeEletronico();
        armazem1.adicionarAoInventario("TV LG", eletronico1);
        armazem1.adicionarAoInventario("Switch", eletronico2);

        System.out.println(armazem1.obterDoInventario("Switch"));

        ArmazemDeComida armazem2 = new ArmazemDeComida();
        armazem2.adicionarAoInventario("feijao", comida2);
        armazem2.adicionarAoInventario("pacoca", comida3);

        System.out.println(armazem2.obterDoInventario("feijao"));
    }
}
