public class DashboardController {
    private DashboardModel model;
    private DashboardView vista;

    public DashboardController(DashboardModel modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = -1;
        
        while (opcion != 0) {
            opcion = vista.mostrarMenuPrincipal();
            
            if (opcion == 1) {
                vista.mostrarListaWidgets(modelo.obtenerWidgets());
            } else if (opcion == 2) {
                String idInteraccion = vista.solicitarId();
                Widget target = modelo.buscarWidget(idInteraccion);
                if (target != null) {
                    vista.mostrarDetalleWidget(target);
                    if (target instanceof Interactivo) {
                        // El controlador obtiene la respuesta y se la manda a la vista para imprimir
                        String resultadoInteraccion = ((Interactivo) target).interactuar();
                        vista.mostrarMensaje(resultadoInteraccion);
                    } else {
                        vista.mostrarMensaje("\n[i] Este widget es puramente estático y no soporta interacción.");
                    }
                } else {
                    vista.mostrarMensaje("\n[!] El ID ingresado no existe en el catálogo.");
                }
            } else if (opcion == 3) {
                String idBuscado = vista.solicitarId();
                Widget encontradoId = modelo.buscarWidget(idBuscado);
                vista.mostrarDetalleWidget(encontradoId);
            } else if (opcion == 4) {
                String nombreBuscado = vista.solicitarNombre();
                var resultados = modelo.buscarWidget(nombreBuscado, true);
                vista.mostrarListaResultadosBusqueda(resultados);
            } else if (opcion == 5) {
                modelo.ordenarPorMemoria();
                vista.mostrarMensaje("\n[✔] Widgets ordenados exitosamente por consumo de memoria (KB).");
                vista.mostrarListaWidgets(modelo.obtenerWidgets());
            } else if (opcion == 6) {
                vista.mostrarMensaje("\n[i] Principio Abierto/Cerrado (OCP): Para agregar un nuevo widget el próximo mes,");
                vista.mostrarMensaje("basta con crear una nueva clase extendiendo de Widget e implementando las interfaces necesarias.");
            } else if (opcion == 0) {
                vista.mostrarMensaje("\nSaliendo del sistema Dashboard. ¡Hasta pronto!");
            } else {
                vista.mostrarMensaje("\n[!] Opción inválida. Por favor seleccione una opción del menú.");
            }
        }
    }
}