package command;

import java.util.ArrayList;
import java.util.List;

public class Invocador {
    private List<Command> comandos = new ArrayList<>();

    public void agregarComando(Command command){
        comandos.add(command);
    }
    public void ejecutarComandos(){
        for(Command comando : comandos){
            comando.ejecutar();
        }
    }
}
