package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.factory.ApplianceCreator;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parser.ApplianceParser;

import java.util.Map;

public class SpeakersCreator implements ApplianceCreator {
    private static final String REGEX_HYPHEN = "-";

    @Override
    public Appliance createAppliance(String applianceData) {
        ApplianceParser parser = ApplianceParser.getInstance();
        Map<String, String> applianceParameter = parser.parseAppliance(applianceData);
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        int numberOfSpeakers = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.NUMBER_OF_SPEAKERS.getParameterName()));
        double startFrequencyRange = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREQUENCY_RANGE.getParameterName()).split(REGEX_HYPHEN)[0]);
        double endFrequencyRange = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREQUENCY_RANGE.getParameterName()).split(REGEX_HYPHEN)[1]);
        double cordLength = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CORD_LENGTH.getParameterName()));
        return new Speakers(powerConsumption, numberOfSpeakers, startFrequencyRange, endFrequencyRange, cordLength);
    }
}
