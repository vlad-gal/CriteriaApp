package by.tc.task01.entity;

public class Laptop implements Appliance {
    private String name;
    private double batteryCapacity;
    private String operationSystem;
    private double memoryROM;
    private double systemMemory;
    private double cpu;
    private double displayInches;

    public Laptop() {
        name = Laptop.class.getSimpleName();
    }

    public Laptop(double batteryCapacity, String operationSystem, double memoryROM, double systemMemory, double cpu, double displayInches) {
        name = Laptop.class.getSimpleName();
        this.batteryCapacity = batteryCapacity;
        this.operationSystem = operationSystem;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
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

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(laptop.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(laptop.systemMemory, systemMemory) != 0) return false;
        if (Double.compare(laptop.cpu, cpu) != 0) return false;
        if (Double.compare(laptop.displayInches, displayInches) != 0) return false;
        if (!name.equals(laptop.name)) return false;
        return operationSystem.equals(laptop.operationSystem);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + operationSystem.hashCode();
        temp = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(systemMemory);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", operationSystem='").append(operationSystem).append('\'');
        sb.append(", memoryROM=").append(memoryROM);
        sb.append(", systemMemory=").append(systemMemory);
        sb.append(", cpu=").append(cpu);
        sb.append(", displayInches=").append(displayInches);
        sb.append('}');
        return sb.toString();
    }
}
