import java.util.List;
import java.util.Scanner;

public class DashboardView {
    private Scanner scanner;

    public DashboardView() {
        this.scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("\n========================================");
        System.out.println("     DASHBOARD MODULAR EMPRESARIAL      ");
        System.out.println("========================================");
        System.out.println("1. Listar todos los widgets");
        System.out.println("2. Interactuar con un widget específico");
        System.out.println("3. Buscar widget por ID");
        System.out.println("4. Buscar widget por Nombre");
        System.out.println("5. Ordenar widgets por consumo de memoria");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número válido: ");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void showWidgetList(List<Widget> widgets) {
        System.out.println("\n--- LISTADO DE WIDGETS ACTIVOS ---");
        if (widgets.isEmpty()) {
            System.out.println("No hay widgets registrados.");
            return;
        }
        for (int i = 0; i < widgets.size(); i++) {
            Widget w = widgets.get(i);
            System.out.println((i + 1) + ". " + w.toString() + " | Tipo: " + w.getClass().getSimpleName());
            System.out.println(w.render()); 
            System.out.println("----------------------------------------");
        }
    }

    public void showWidgetDetail(Widget w) {
        if (w == null) {
            System.out.println("\n[!] Widget no encontrado.");
        } else {
            System.out.println("\n--- DETALLE DEL WIDGET ---");
            System.out.println(w.toString());
            System.out.println(w.render());
        }
    }

    public void showSearchResultsList(List<Widget> widgets) {
        if (widgets.isEmpty()) {
            System.out.println("\n[!] No se encontraron widgets con ese criterio.");
            return;
        }
        System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
        for (Widget w : widgets) {
            System.out.println(w.toString());
        }
    }

    public String requestId() {
        System.out.print("Ingrese el ID del widget (ej. W-01): ");
        return scanner.nextLine().trim();
    }
    
    public String requestName() {
        System.out.print("Ingrese el nombre o palabra clave a buscar: ");
        return scanner.nextLine().trim();
    }

    public String showMessage(String message) {
        return message;
    }
}