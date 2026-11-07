import java.time.LocalTime;

public class DigitalClock extends Widget {
    private boolean is24HourFormat;

    public DigitalClock(String id, String name, double memoryUsageKB, boolean is24HourFormat) {
        super(id, name, memoryUsageKB);
        this.is24HourFormat = is24HourFormat;
    }

    @Override
    public String render() {
        LocalTime currentTime = LocalTime.now();
        return "[RELOJ DIGITAL] Mostrando hora actual (" + (is24HourFormat ? "24h" : "12h") + "): " + currentTime.format(is24HourFormat ? java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss") : java.time.format.DateTimeFormatter.ofPattern("hh:mm:ss a"))    ;
    }
}