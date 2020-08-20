package by.tc.task01.service.validation;

import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidatorTest {
    Criteria criteria;

    @BeforeMethod
    public void setUp() {
        criteria = new Criteria(Oven.class.getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        criteria = null;
    }

    @Test
    public void testCriteriaValidatorSuccess() {
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
        boolean condition = Validator.criteriaValidator(criteria);
        assertTrue(condition);
    }

    @Test
    public void testCriteriaValidatorIncorrectName() {
        criteria = new Criteria("1122");
        boolean condition = Validator.criteriaValidator(criteria);
        assertFalse(condition);
    }

    @Test
    public void testCriteriaValidatorIncorrectParameterName() {
        criteria.add("1231", "w");
        boolean condition = Validator.criteriaValidator(criteria);
        assertFalse(condition);
    }

    @Test
    public void testCriteriaValidatorIncorrectParameterValue() {
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), "-!!13--1 ");
        boolean condition = Validator.criteriaValidator(criteria);
        assertFalse(condition);
    }
}