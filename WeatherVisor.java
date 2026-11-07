public class WeatherVisor extends Widget implements Interactive {
    private String city;
    private double temperature;

    public WeatherVisor(String id, String name, double memoryUsageKB, String city, double temperature) {
        super(id, name, memoryUsageKB);
        this.city = city;
        this.temperature = temperature;
    }

    @Override
    public String render() {
        return "[VISOR CLIMA] Dibujando widget de clima para " + city + " | Temperatura: " + temperature + "°C";
    }

    @Override
    public String interact() {
        return "--> Interacción: Actualizando datos meteorológicos en tiempo real para " + city;
    }

    public void updateWeather(double newTemp) {
        this.temperature = newTemp;
    }
}