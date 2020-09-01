package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class RefrigeratorCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        double weight = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WEIGHT.getParameterName()));
        double freezerCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREEZER_CAPACITY.getParameterName()));
        double overallCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.OVERALL_CAPACITY.getParameterName()));
        double height = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.HEIGHT.getParameterName()));
        double width = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WIDTH.getParameterName()));
        return new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }
}
