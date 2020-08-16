package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        System.out.println("Found Appliances:\n=========================");
        appliances.forEach(System.out::println);
        System.out.println("=========================");
    }
}
