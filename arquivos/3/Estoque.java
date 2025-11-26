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

    // Carrega os produtos do arquivo CSV
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
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    // Salva os produtos no arquivo CSV
    private void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                writer.write(p.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    // Adicionar produto com ID único
    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarProdutos();
        System.out.println("Produto adicionado com sucesso!");
    }

    // Excluir produto pelo ID
    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Exibir todos os produtos
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    // Atualizar quantidade pelo ID
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarProdutos();
                System.out.println("Quantidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    // Gera novo ID único
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
