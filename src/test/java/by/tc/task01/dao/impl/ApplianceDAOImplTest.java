package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.exception.DaoException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ApplianceDAOImplTest {
    ApplianceDAO dao;
    List<Appliance> expected;
    Criteria criteria;

    @BeforeClass
    public void setUp() {
        dao = new ApplianceDAOImpl();
        expected = new ArrayList<>();
        expected.add(new Oven(1000, 10, 32, 60, 45.5, 59.5));
        criteria = new Criteria(Oven.class.getSimpleName());
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 32);
    }

    @Test
    public void testFindSuccess() throws DaoException {
        List<Appliance> actual = dao.find(criteria);
        assertEquals(actual, expected);
    }
}