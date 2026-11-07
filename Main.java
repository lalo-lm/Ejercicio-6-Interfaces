public class Main {
    public static void main(String[] args) {
        DashboardModel model = new DashboardModel();
        DashboardView view = new DashboardView();
        DashboardController controller = new DashboardController(model, view);
        controller.start();
    }
}