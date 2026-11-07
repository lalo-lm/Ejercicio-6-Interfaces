public class AlertNotification extends Widget implements Interactive {
    private String urgencyLevel;
    private String message;

    public AlertNotification(String id, String name, double memoryUsageKB, String urgencyLevel, String message) {
        super(id, name, memoryUsageKB);
        this.urgencyLevel = urgencyLevel;
        this.message = message;
    }

    @Override
    public String render() {
        return "[ALERTA - " + urgencyLevel.toUpperCase() + "] Renderizando banner: " + message;
    }

    @Override
    public String interact() {
        return "--> Interacción: Reconociendo y descartando alerta de nivel " + urgencyLevel.toUpperCase();
    }
}