package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.parameter.ApplianceParameter;
import by.tc.task01.parameter.ApplianceType;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEX_STRING = "[\\p{Alpha}\\d-]+";

    public static boolean criteriaValidator(Criteria criteria) {
        boolean flag = false;
        boolean validCriteriaName = isValidCriteriaName(criteria);
        boolean validParameterName = isValidParameterName(criteria);
        boolean validParameterValue = isValidParameterValue(criteria);
        if (validCriteriaName && validParameterName && validParameterValue) {
            flag = true;
        }
        return flag;
    }

    private static boolean isValidCriteriaName(Criteria criteria) {
        if (criteria.getGroupSearchName() == null || criteria.getGroupSearchName().isEmpty()) {
            return false;
        }
        ApplianceType[] applianceNames = ApplianceType.values();
        boolean flag = false;
        for (ApplianceType applianceName : applianceNames) {
            if (criteria.getGroupSearchName().equalsIgnoreCase(applianceName.name())) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isValidParameterName(Criteria criteria) {
        ApplianceParameter[] parameters = ApplianceParameter.values();
        boolean flag = false;
        for (Map.Entry parameter : criteria.entrySet()) {
            if (parameter.getKey() == null) {
                return false;
            }
            for (int i = 0; i < parameters.length; i++) {
                if (parameter.getKey().toString().equalsIgnoreCase(parameters[i].getParameterName())) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static boolean isValidParameterValue(Criteria criteria) {
        ApplianceParameter[] parameters = ApplianceParameter.values();
        boolean flag = false;
        Pattern pattern = Pattern.compile(REGEX_STRING);
        Matcher matcher;
        for (Map.Entry parameter : criteria.entrySet()) {
            if (parameter.getKey() == null) {
                return false;
            }
            for (int i = 0; i < parameters.length; i++) {
                Object value = parameter.getValue();
                if (value instanceof Number) {
                    flag = Double.parseDouble(value.toString()) > 0;
                } else if (value instanceof String) {
                    matcher = pattern.matcher(value.toString());
                    flag = matcher.find();
                }
            }
        }
        return flag;
    }
}