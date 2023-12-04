package sistema;

import java.util.HashMap;
import java.util.Map;

public class ComandosHandler {
    private Map<String, Comando> comandos;

    public ComandosHandler() {
        comandos = new HashMap<>();
        inicializarComandos();
    }

    private void inicializarComandos() {
        comandos.put("emp", new EmprestimoComando());
        comandos.put("dev", new DevolucaoComando());
        comandos.put("res", new ReservaComando());
        comandos.put("obs", new ObservadorComando());
        // Adicione outros comandos conforme necessário
    }

    public void processarComando(String comando) {
        String[] partes = comando.split(" ");
        if (partes.length > 0) {
            String nomeComando = partes[0].toLowerCase();
            Comando cmd = comandos.get(nomeComando);

            if (cmd != null) {
                cmd.executar(partes);
            } else {
                System.out.println("Comando inválido");
            }
        }
    }
}
