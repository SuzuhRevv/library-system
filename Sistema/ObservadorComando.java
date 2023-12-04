package sistema;

import java.util.Scanner;

public class ObservadorComando implements Comando {
    @Override
    public void executar(String[] parametros) {
        // Lógica para processar o comando de observador
        System.out.println("Comando de observador executado");
    }
}
