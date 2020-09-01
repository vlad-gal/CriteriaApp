package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class VacuumCleanerCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        String filterType = applianceParameter.get(ApplianceParameter.FILTER_TYPE.getParameterName());
        String bagType = applianceParameter.get(ApplianceParameter.BAG_TYPE.getParameterName());
        String wandType = applianceParameter.get(ApplianceParameter.WAND_TYPE.getParameterName());
        double motorSpeedRegulation = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.MOTOR_SPEED_REGULATION.getParameterName()));
        double cleaningWidth = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CLEANING_WIDTH.getParameterName()));
        return new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }
}
