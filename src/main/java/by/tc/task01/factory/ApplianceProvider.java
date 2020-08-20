package by.tc.task01.factory;

public class ApplianceProvider {
    public ApplianceCreator defineCreator(String applianceName) {
        return CreatorType.valueOf(applianceName.toUpperCase()).getCreator();
    }
}
