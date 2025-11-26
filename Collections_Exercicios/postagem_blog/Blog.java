import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    // Adiciona postagem, verificando duplicidade (mesmo autor + mesmo título)
    public void adicionarPostagem(Post postagem) throws Exception {
        if (postagens.contains(postagem)) {
            throw new Exception("Postagem jah existente");
        }
        postagens.add(postagem);
    }

    // Retorna todos os autores ordenados pelo nome
    public Set<Autor> obterTodosAutores() {
        return new TreeSet<>(postagens.stream()
                .map(Post::getAutor)
                .toList());
    }

    // Retorna contagem por categoria, mantendo ordem natural do enum
    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new EnumMap<>(Categorias.class);
        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    // Retorna posts de um autor, ordenados pelo título
    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                posts.add(p);
            }
        }
        return posts;
    }

    // Retorna posts de uma categoria, ordenados pelo título
    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria() == categoria) {
                posts.add(p);
            }
        }
        return posts;
    }

    // Retorna todos os posts agrupados por categoria
    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new EnumMap<>(Categorias.class);
        for (Post p : postagens) {
            mapa.putIfAbsent(p.getCategoria(), new TreeSet<>());
            mapa.get(p.getCategoria()).add(p);
        }
        return mapa;
    }

    // Retorna todos os posts agrupados por autor
    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post p : postagens) {
            mapa.putIfAbsent(p.getAutor(), new TreeSet<>());
            mapa.get(p.getAutor()).add(p);
        }
        return mapa;
    }
}
