package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class OvenCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        double weight = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WEIGHT.getParameterName()));
        double capacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CAPACITY.getParameterName()));
        double depth = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.DEPTH.getParameterName()));
        double height = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.HEIGHT.getParameterName()));
        double width = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WIDTH.getParameterName()));
        return new Oven(powerConsumption, weight, capacity, depth, height, width);
    }
}
