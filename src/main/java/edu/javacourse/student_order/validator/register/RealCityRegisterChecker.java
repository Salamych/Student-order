
package edu.javacourse.student_order.validator.register;

import edu.javacourse.student_order.domain.Person;
import edu.javacourse.student_order.domain.register.CityRegisterResponse;
import edu.javacourse.student_order.exception.CityRegisterException;
import edu.javacourse.student_order.exception.TransportException;


public class RealCityRegisterChecker implements CityRegisterChecker{
    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException{
    return null;
    }
}
