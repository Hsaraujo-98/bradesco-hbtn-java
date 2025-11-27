public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        // Criando duas threads
        ThreadContador t1 = new ThreadContador(contador);
        ThreadContador t2 = new ThreadContador(contador);

        // Iniciando as threads
        t1.start();
        t2.start();

        // Aguardando ambas terminarem
        t1.join();
        t2.join();

        // Exibindo o valor final do contador
        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
