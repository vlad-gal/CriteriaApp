package by.tc.task01.service.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.exception.ServiceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ApplianceServiceImplTest {
    ApplianceService service;
    List<Appliance> expected;
    Criteria criteria;

    @BeforeMethod
    public void setUp() {
        service = new ApplianceServiceImpl();
        expected = new ArrayList<>();
        expected.add(new Oven(1000, 10, 32, 60, 45.5, 59.5));
        criteria = new Criteria(Oven.class.getSimpleName());
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 32);
    }

    @Test
    public void testFindSuccess() throws ServiceException {
        List<Appliance> actual = service.find(criteria);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Incorrect criteria")
    public void testFindExceptionMessage() throws ServiceException {
        service.find(new Criteria("112"));
    }
}