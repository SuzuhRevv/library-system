import java.util.ArrayList;
import java.util.List;

class Livro implements ILivro {
    private int codigo;
    private String titulo;
    private String editora;
    private List<String> autores;
    private int edicao;
    private int anoPublicacao;
    private int quantidadeDisponivel;
    private List<Reserva> reservas;
    private List<Emprestimo> emprestimos;

    // Construtores, getters e setters

    public void adicionarExemplar() {
        quantidadeDisponivel++;
    }

    public void removerExemplar() {
        quantidadeDisponivel--;
    }
}