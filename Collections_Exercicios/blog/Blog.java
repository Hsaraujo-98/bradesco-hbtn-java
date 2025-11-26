import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        postagens.add(postagem);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }
}
