package by.tc.task01.parser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ApplianceParserTest {
    ApplianceParser parser;

    @BeforeClass
    public void setUp() {
        parser = ApplianceParser.getInstance();
    }

    @Test
    public void testParseApplianceSuccess() {
        String dataToParse = "Oven : POWER_CONSUMPTION=1500, WEIGHT=12, CAPACITY=33, DEPTH=60, HEIGHT=45, WIDTH=68";
        Map<String, String> actual = parser.parseAppliance(dataToParse);
        Map<String, String> expected = new HashMap<>();
        expected.put("NAME", "OVEN");
        expected.put("POWER_CONSUMPTION", "1500");
        expected.put("CAPACITY", "33");
        expected.put("WIDTH", "68");
        expected.put("WEIGHT", "12");
        expected.put("HEIGHT", "45");
        expected.put("DEPTH", "60");
        assertEquals(actual, expected);
    }
}