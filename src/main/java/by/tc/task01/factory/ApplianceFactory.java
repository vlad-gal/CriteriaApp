package by.tc.task01.factory;

import by.tc.task01.entity.Appliance;

public class ApplianceFactory {
    private static ApplianceFactory instance;
    private final ApplianceProvider provider = new ApplianceProvider();
    private static final String REGEX_DELIMITER = ":";

    private ApplianceFactory() {
    }

    public static ApplianceFactory getInstance() {
        if (instance == null) {
            instance = new ApplianceFactory();
        }
        return instance;
    }

    public Appliance createAppliance(String applianceData) {
        ApplianceCreator creator = provider.defineCreator(applianceData.split(REGEX_DELIMITER)[0].trim());
        return creator.createAppliance(applianceData);
    }
}
