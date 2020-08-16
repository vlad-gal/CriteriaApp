package by.tc.task01.factory;

import by.tc.task01.factory.impl.*;

public enum CreatorType {
    LAPTOP(new LaptopCreator()),
    OVEN(new OvenCreator()),
    REFRIGERATOR(new RefrigeratorCreator()),
    VACUUMCLEANER(new VacuumCleanerCreator()),
    TABLETPC(new TabletPCCreator()),
    SPEAKERS(new SpeakersCreator());

    private ApplianceCreator creator;

    CreatorType(ApplianceCreator creator) {
        this.creator = creator;
    }

    public ApplianceCreator getCreator() {
        return creator;
    }
}
