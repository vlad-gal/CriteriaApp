package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LaptopCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new LaptopCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHES=18";
        Appliance actual = creator.createAppliance(dataToCreate);
        Laptop expected = new Laptop(1, "WINDOWS", 4000, 1000, 1.2, 18);
        assertEquals(actual, expected);
    }
}