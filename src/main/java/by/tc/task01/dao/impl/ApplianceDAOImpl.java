package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.exception.DaoException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.factory.ApplianceFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String PROPERTIES = "config";
    private static final String FILE_PATH = "filePath";
    private static final String REGEX_EQUAL = "=";

    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        ResourceBundle bundle = ResourceBundle.getBundle(PROPERTIES);
        String fileName = bundle.getString(FILE_PATH);
        URL url = getClass().getClassLoader().getResource(fileName);
        File file;
        if (url != null) {
            file = new File(url.getFile());
        } else {
            throw new DaoException("File not exist");
        }
        Path path = Paths.get(file.getPath());
        List<String> appliances;
        try (Stream<String> appliance = Files.lines(path)) {
            appliances = appliance
                    .filter(app -> !app.isEmpty())
                    .filter(app -> app.contains(criteria.getGroupSearchName()))
                    .filter(app -> {
                        String temp = app.toUpperCase();
                        boolean flag = false;
                        for (Map.Entry map : criteria.entrySet()) {
                            String criteriaApp = map.getKey().toString().toUpperCase() + REGEX_EQUAL + map.getValue();
                            if (temp.contains(criteriaApp)) {
                                flag = true;
                            }
                        }
                        return flag;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error while reading appliances from file", e);
        }
        ApplianceFactory factory = ApplianceFactory.getInstance();
        List<Appliance> applianceList = new ArrayList<>();
        for (String applianceData : appliances) {
            Appliance appliance = factory.createAppliance(applianceData);
            applianceList.add(appliance);
        }
        return applianceList;
    }
}