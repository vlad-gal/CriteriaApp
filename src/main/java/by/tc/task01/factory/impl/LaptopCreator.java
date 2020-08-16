package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class LaptopCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        Laptop laptop = new Laptop();
        double batteryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.BATTERY_CAPACITY.getParameterName()));
        String operationSystem = applianceParameter.get(ApplianceParameter.OS.getParameterName());
        double memoryROM = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.MEMORY_ROM.getParameterName()));
        double systemMemory = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.SYSTEM_MEMORY.getParameterName()));
        double CPU = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CPU.getParameterName()));
        double displayInches = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.DISPLAY_INCHES.getParameterName()));
        laptop.setBatteryCapacity(batteryCapacity);
        laptop.setOperationSystem(operationSystem);
        laptop.setMemoryROM(memoryROM);
        laptop.setSystemMemory(systemMemory);
        laptop.setCPU(CPU);
        laptop.setDisplayInches(displayInches);
        return laptop;
    }
}
