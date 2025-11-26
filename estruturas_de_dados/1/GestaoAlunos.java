import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    // Construtor
    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    // Adicionar aluno
    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno);
    }

    // Excluir aluno pelo nome
    public void excluirAluno(String nome) {
        boolean removido = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunos.remove(aluno);
                System.out.println("Aluno removido: " + aluno);
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Aluno com nome '" + nome + "' não encontrado.");
        }
    }

    // Buscar aluno pelo nome
    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno com nome '" + nome + "' não encontrado.");
    }

    // Listar todos os alunos
    public void listarAlunos() {
        System.out.println("\nLista de alunos cadastrados:");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adicionando três alunos
        gestao.adicionarAluno("Ana", 20);
        gestao.adicionarAluno("Bruno", 22);
        gestao.adicionarAluno("Carla", 19);

        // Exibindo todos os alunos
        gestao.listarAlunos();

        // Buscando um aluno
        gestao.buscarAluno("Bruno");

        // Excluindo um aluno
        gestao.excluirAluno("Ana");

        // Tentando excluir um aluno inexistente
        gestao.excluirAluno("Daniel");

        // Buscando outro aluno
        gestao.buscarAluno("Carla");

        // Exibindo lista final
        gestao.listarAlunos();
    }
}
