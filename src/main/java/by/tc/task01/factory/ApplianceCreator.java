package by.tc.task01.factory;

import by.tc.task01.entity.Appliance;

public interface ApplianceCreator {
    Appliance createAppliance(String applianceData);
}
