public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // Capacidade da fila

        // Criando produtores e consumidores
        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);
        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        // Iniciando as threads
        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        // Executa por 20 segundos e encerra
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
