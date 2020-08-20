package by.tc.task01.factory.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.factory.ApplianceCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SpeakersCreatorTest {
    ApplianceCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new SpeakersCreator();
    }

    @Test
    public void testCreateApplianceSuccess() {
        String dataToCreate = "Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, " +
                "FREQUENCY_RANGE=2-4, CORD_LENGTH=2";
        Appliance actual = creator.createAppliance(dataToCreate);
        Speakers expected = new Speakers(15, 2, 2, 4, 2);
        assertEquals(actual, expected);
    }
}