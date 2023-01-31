package edu.javacourse.student_order.dao;

import edu.javacourse.student_order.domain.CountryArea;
import edu.javacourse.student_order.domain.PassportOffice;
import edu.javacourse.student_order.domain.RegisterOffice;
import edu.javacourse.student_order.domain.Street;
import edu.javacourse.student_order.exception.DaoException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



public class DictionaryDaoImplTest {
    
    private final static Logger logger = LogManager.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

//    @Before
//    public void startTest(){
//        System.out.println("START TEST");
//    }
    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        logger.info("TEST {} {}",dt1,dt2);
        List<Street> d = new DictionaryDaoImpl().findStreets("про");

        Assert.assertTrue(d.size() == 2);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOfices("010020000000");

        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOfices("010010000000");

        Assert.assertTrue(ro.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);
        
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);
        
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);
        
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);
    }

}
