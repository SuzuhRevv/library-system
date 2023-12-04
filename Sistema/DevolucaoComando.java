package sistema;

import java.util.Scanner;

public class DevolucaoComando implements IComando {
    @Override
    public void executar(String[] parametros) {
        // Lógica para processar o comando de devolução
        System.out.println("Comando de devolução executado");
    }
}
