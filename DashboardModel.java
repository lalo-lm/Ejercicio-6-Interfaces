import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardModel {
    private List<Widget> widgets;

    public DashboardModel() {
        this.widgets = new ArrayList<>();
        startCatalog();
    }

    public void startCatalog() {
        widgets.add(new WeatherVisor("W-01", "Clima Ciudad de Guatemala", 128.5, "Guatemala", 22.4));
        widgets.add(new DigitalClock("W-02", "Reloj Principal UTC", 45.0, true));
        widgets.add(new ToDoList("W-03", "Pendientes Proyecto POO", 210.2));
        widgets.add(new AlertNotification("W-04", "Alerta Servidor CPU", 88.0, "Alta", "Uso de CPU > 90%"));
        widgets.add(new WeatherVisor("W-05", "Clima Quetzaltenango", 115.0, "Quetzaltenango", 14.0));
        widgets.add(new DigitalClock("W-06", "Reloj Secundario (12h)", 42.0, false));
        widgets.add(new ToDoList("W-07", "Compras de Oficina", 150.0));
        widgets.add(new AlertNotification("W-08", "Aviso de Mantenimiento", 64.0, "Media", "Reiniciando a medianoche"));
        widgets.add(new WeatherVisor("W-09", "Clima Escuintla", 130.0, "Escuintla", 31.5));
        widgets.add(new ToDoList("W-10", "Bitácora de Despliegue", 312.8));
    }

    public List<Widget> obtainWidgets() {
        return widgets;
    }

    public void addWidget(Widget w) {
        widgets.add(w);
    }

    public Widget searchWidget(String id) {
        for (Widget w : widgets) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }

    public List<Widget> searchWidgetN(String name) {
        List<Widget> results = new ArrayList<>();
        for (Widget w : widgets) {
            if (w.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(w);
            }
            else {
                if (w.getName().equalsIgnoreCase(name)) {
                    results.add(w);
                }
            }
        }
        return results;
    }

    public void sortByMemory() {
        Collections.sort(widgets);
    }
}