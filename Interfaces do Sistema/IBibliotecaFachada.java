package sistema;

public interface IBibliotecaFacade {
    void realizarEmprestimo(int codigoUsuario, int codigoLivro);
    void realizarDevolucao(int codigoUsuario, int codigoLivro);
    void realizarReserva(int codigoUsuario, int codigoLivro);
    void registrarObservador(int codigoUsuario, int codigoLivro);
    // Adicione outros métodos conforme necessário
}
