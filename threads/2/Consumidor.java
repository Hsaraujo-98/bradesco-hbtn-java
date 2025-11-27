public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = fila.retirar();
                Thread.sleep(500); // Simula processamento
            }
        } catch (InterruptedException e) {
            System.out.println("Consumidor interrompido.");
        }
    }
}
