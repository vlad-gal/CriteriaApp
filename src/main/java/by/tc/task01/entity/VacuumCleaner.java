package by.tc.task01.entity;

public class VacuumCleaner implements Appliance {
    private String name;
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {
        name = VacuumCleaner.class.getSimpleName();
    }

    public VacuumCleaner(double powerConsumption, String filterType, String bagType, String wandType, double motorSpeedRegulation, double cleaningWidth) {
        name = VacuumCleaner.class.getSimpleName();
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public String getName() {
        return name;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner cleaner = (VacuumCleaner) o;

        if (Double.compare(cleaner.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(cleaner.motorSpeedRegulation, motorSpeedRegulation) != 0) return false;
        if (Double.compare(cleaner.cleaningWidth, cleaningWidth) != 0) return false;
        if (!name.equals(cleaner.name)) return false;
        if (!filterType.equals(cleaner.filterType)) return false;
        if (!bagType.equals(cleaner.bagType)) return false;
        return wandType.equals(cleaner.wandType);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + filterType.hashCode();
        result = 31 * result + bagType.hashCode();
        result = 31 * result + wandType.hashCode();
        temp = Double.doubleToLongBits(motorSpeedRegulation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cleaningWidth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VacuumCleaner{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", filterType='").append(filterType).append('\'');
        sb.append(", bagType='").append(bagType).append('\'');
        sb.append(", wandType='").append(wandType).append('\'');
        sb.append(", motorSpeedRegulation=").append(motorSpeedRegulation);
        sb.append(", cleaningWidth=").append(cleaningWidth);
        sb.append('}');
        return sb.toString();
    }
}
