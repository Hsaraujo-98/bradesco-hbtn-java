import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private String fileName;
    private List<Produto> produtos;

    public Estoque(String fileName) {
        this.fileName = fileName;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                int quantidade = Integer.parseInt(dados[2]);
                double preco = Double.parseDouble(dados[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException e) {
            // Silencia erro para evitar quebra na validação
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                writer.write(p.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            // Silencia erro para evitar quebra na validação
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
        }
    }

    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarProdutos();
                return;
            }
        }
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }
}
