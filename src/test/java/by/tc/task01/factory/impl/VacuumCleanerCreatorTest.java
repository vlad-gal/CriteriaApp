package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VacuumCleanerCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new VacuumCleanerCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "VacuumCleaner : POWER_CONSUMPTION=100, FILTER_TYPE=A, BAG_TYPE=A2, " +
                "WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=3000, CLEANING_WIDTH=20";
        Appliance actual = creator.createAppliance(dataToCreate);
        VacuumCleaner expected = new VacuumCleaner(100, "A", "A2", "ALL-IN-ONE", 3000, 20);
        assertEquals(actual, expected);
    }
}