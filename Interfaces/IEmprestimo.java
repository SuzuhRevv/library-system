package entidades;

public interface IEmprestimo {
    ILivro getLivro();
    IUsuario getUsuario();
    String getDataEmprestimo();
    // Adicione outros métodos conforme necessário
}
