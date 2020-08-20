package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TabletPCCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new TabletPCCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "TabletPC : BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, " +
                "FLASH_MEMORY_CAPACITY=2, COLOR=blue";
        Appliance actual = creator.createAppliance(dataToCreate);
        TabletPC expected = new TabletPC(3, 14, 8000, 2, "BLUE");
        assertEquals(actual, expected);
    }
}