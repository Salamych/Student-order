
package edu.javacourse.student_order.dao;

import edu.javacourse.student_order.domain.CountryArea;
import edu.javacourse.student_order.domain.PassportOffice;
import edu.javacourse.student_order.domain.RegisterOffice;
import edu.javacourse.student_order.domain.Street;
import edu.javacourse.student_order.exception.DaoException;
import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOfices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOfices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;
}
