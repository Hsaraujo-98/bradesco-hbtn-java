import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private final Queue<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // Espera até que haja espaço na fila
        }
        fila.add(item);
        System.out.println("Produtor adicionou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll(); // Notifica consumidores
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // Espera até que haja um item na fila
        }
        int item = fila.poll();
        System.out.println("Consumidor retirou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll(); // Notifica produtores
        return item;
    }
}
