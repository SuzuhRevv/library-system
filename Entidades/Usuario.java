import java.time.LocalDate;

public abstract class Usuario implements IUsuario {
    private int codigo;
    private String nome;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;

    // Construtores, getters e setters

    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Adiciona um empréstimo à lista de empréstimos do usuário
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    // Remove um empréstimo da lista de empréstimos do usuário
    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }

    // Adiciona uma reserva à lista de reservas do usuário
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Remove uma reserva da lista de reservas do usuário
    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    // Método abstrato para obter o tempo de empréstimo específico de cada tipo de usuário
    public abstract int getTempoEmprestimo();

    // Método para calcular a data de devolução com base no tempo de empréstimo
    public LocalDate calcularDataDevolucao() {
        return LocalDate.now().plusDays(getTempoEmprestimo());
    }
}