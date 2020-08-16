package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class TabletPCCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        TabletPC tabletPC = new TabletPC();
        double batteryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.BATTERY_CAPACITY.getParameterName()));
        double displayInches = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.DISPLAY_INCHES.getParameterName()));
        double memoryROM = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.MEMORY_ROM.getParameterName()));
        double flashMemoryCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FLASH_MEMORY_CAPACITY.getParameterName()));
        String color = applianceParameter.get(ApplianceParameter.COLOR.getParameterName());
        tabletPC.setBatteryCapacity(batteryCapacity);
        tabletPC.setDisplayInches(displayInches);
        tabletPC.setMemoryROM(memoryROM);
        tabletPC.setFlashMemoryCapacity(flashMemoryCapacity);
        tabletPC.setColor(color);
        return tabletPC;
    }
}
