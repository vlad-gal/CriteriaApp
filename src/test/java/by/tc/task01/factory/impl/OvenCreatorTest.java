package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OvenCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new OvenCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5";
        Appliance actual = creator.createAppliance(dataToCreate);
        Oven expected = new Oven(1000, 10, 32, 60, 45.5, 59.5);
        assertEquals(actual, expected);
    }
}