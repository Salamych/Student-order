
package edu.javacourse.student_order.validator.register;

import edu.javacourse.student_order.domain.Person;
import edu.javacourse.student_order.domain.register.CityRegisterResponse;
import edu.javacourse.student_order.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) 
            throws CityRegisterException;
}
