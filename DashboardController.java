public class DashboardController {
    private DashboardModel model;
    private DashboardView view;

    public DashboardController(DashboardModel model, DashboardView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int option = -1;
        
        while (option != 0) {
            option = view.showMainMenu();
            
            if (option == 1) {
                view.showWidgetList(model.obtainWidgets());
            } else if (option == 2) {
                String idInteraction = view.requestId();
                Widget target = model.searchWidget(idInteraction);
                if (target != null) {
                    view.showWidgetDetail(target);
                    if (target instanceof Interactive) {
                        // El controlador obtiene la respuesta y se la manda a la vista para imprimir
                        String resultInteraction = ((Interactive) target).interact();
                        view.showMessage(resultInteraction);
                    } else {
                        view.showMessage("\n[i] Este widget es puramente estático y no soporta interacción.");
                    }
                } else {
                    view.showMessage("\n[!] El ID ingresado no existe en el catálogo.");
                }
            } else if (option == 3) {
                String searchedId = view.requestId();
                Widget foundId = model.searchWidget(searchedId);
                view.showWidgetDetail(foundId);
            } else if (option == 4) {
                String searchedName = view.requestName();
                var results = model.searchWidgetN(searchedName);
                view.showSearchResultsList(results);
            } else if (option == 5) {
                model.sortByMemory();
                view.showMessage("\n[✔] Widgets ordenados exitosamente por consumo de memoria (KB).");
                view.showWidgetList(model.obtainWidgets());
            } else if (option == 0) {
                view.showMessage("\nSaliendo del sistema Dashboard. ¡Hasta pronto!");
            } else {
                view.showMessage("\n[!] Opción inválida. Por favor seleccione una opción del menú.");
            }
        }
    }
}