package by.tc.task01.entity;

public class TabletPC implements Appliance {
    private String name;
    private double batteryCapacity;
    private double displayInches;
    private double memoryROM;
    private double flashMemoryCapacity;
    private String color;

    public TabletPC() {
        name = TabletPC.class.getSimpleName();
    }

    public TabletPC(double batteryCapacity, double displayInches, double memoryROM, double flashMemoryCapacity, String color) {
        name = TabletPC.class.getSimpleName();
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(tabletPC.displayInches, displayInches) != 0) return false;
        if (Double.compare(tabletPC.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) != 0) return false;
        if (!name.equals(tabletPC.name)) return false;
        return color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flashMemoryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TabletPC{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", displayInches=").append(displayInches);
        sb.append(", memoryROM=").append(memoryROM);
        sb.append(", flashMemoryCapacity=").append(flashMemoryCapacity);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
