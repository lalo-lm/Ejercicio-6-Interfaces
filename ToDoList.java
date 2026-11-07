import java.util.ArrayList;
import java.util.List;

public class ToDoList extends Widget implements Interactive {
    private List<String> toDos;

    public ToDoList(String id, String name, double memoryUsageKB) {
        super(id, name, memoryUsageKB);
        this.toDos = new ArrayList<>();
    }

    @Override
    public String render() {
        return "[LISTA TAREAS] Dibujando lista '" + name + "' con " + toDos.size() + " pendientes.";
    }

    @Override
    public String interact() {
        return "--> Interacción: Abriendo panel de tareas pendientes.";
    }

    public void addToDos(String tarea) {
        toDos.add(tarea);
    }
}