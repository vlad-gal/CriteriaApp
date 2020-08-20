package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RefrigeratorCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new RefrigeratorCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "Refrigerator : POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, " +
                "OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70";
        Appliance actual = creator.createAppliance(dataToCreate);
        Refrigerator expected = new Refrigerator(100, 20, 10, 300, 200, 70);
        assertEquals(actual, expected);
    }
}