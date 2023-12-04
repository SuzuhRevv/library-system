public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(int codigo, String nome) {
        super(codigo, nome);
        setQuantidadeMaximaEmprestimos(3);
    }

    @Override
    public int getTempoEmprestimo() {
        return 3; // Aluno de Graduação pode ficar com o livro por 3 dias
    }
}

public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(int codigo, String nome) {
        super(codigo, nome);
        setQuantidadeMaximaEmprestimos(4);
    }

    @Override
    public int getTempoEmprestimo() {
        return 4; // Aluno de Pós-Graduação pode ficar com o livro por 4 dias
    }
}

public class Professor extends Usuario {
    public Professor(int codigo, String nome) {
        super(codigo, nome);
        // Professores podem ter uma quantidade ilimitada de empréstimos
    }

    @Override
    public int getTempoEmprestimo() {
        return 7; // Professor pode ficar com o livro por 7 dias
    }
}