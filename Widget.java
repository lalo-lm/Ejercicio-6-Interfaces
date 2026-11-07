abstract class Widget implements Renderable, Comparable<Widget> {
    protected String id;
    protected String name;
    protected double memoryUsageKB;

    public Widget(String id, String name, double memoryUsageKB) {
        this.id = id;
        this.name = name;
        this.memoryUsageKB = memoryUsageKB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMemoryUsageKB() {
        return memoryUsageKB;
    }

    public void setMemoryUsageKB(double memoryUsageKB) {
        this.memoryUsageKB = memoryUsageKB;
    }

    @Override
    public double obtainMemoryUsage() {
        return this.memoryUsageKB;
    }

    @Override
    public int compareTo(Widget other) {
        return Double.compare(this.memoryUsageKB, other.memoryUsageKB);
    }

    @Override
    public String toString() {
        return "Widget [ID= " + id + "|" +
                ", Nombre= " + name + "|" +
                ", Consumo de Memoria =" + memoryUsageKB +
                "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Widget other = (Widget) obj;
        return id.equals(other.id);
    }
}