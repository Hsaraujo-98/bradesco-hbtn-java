import java.util.Random;

public class Produtor extends Thread {
    private final Fila fila;
    private final Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = random.nextInt(100) + 1; // Número entre 1 e 100
                fila.adicionar(numero);
                Thread.sleep(1000); // Simula tempo de produção
            }
        } catch (InterruptedException e) {
            System.out.println("Produtor interrompido.");
        }
    }
}
