
package edu.javacourse.student_order.validator;

import edu.javacourse.student_order.domain.Child;
import edu.javacourse.student_order.domain.Person;
import edu.javacourse.student_order.domain.StudentOrder;
import edu.javacourse.student_order.domain.register.AnswerCityRegister;
import edu.javacourse.student_order.domain.register.AnswerCityRegisterItem;
import edu.javacourse.student_order.domain.register.CityRegisterResponse;
import edu.javacourse.student_order.exception.CityRegisterException;
import edu.javacourse.student_order.exception.TransportException;
import edu.javacourse.student_order.validator.register.CityRegisterChecker;
import edu.javacourse.student_order.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    
    public static final String IN_CODE = "NO_GRN";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();
      
            ans.addItem(checkPerson(so.getHusband()));
             ans.addItem(checkPerson(so.getWife()));
            for (Child child : so.getChildren()) {
                ans.addItem(checkPerson(child));

            }

        
        return ans;
    }
    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
    try {            
         CityRegisterResponse tmp = personChecker.checkPerson(person);
         status = tmp.isExisting()? AnswerCityRegisterItem.CityStatus.YES:
                 AnswerCityRegisterItem.CityStatus.NO;
         
        }
         catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        } catch (Exception ex){
        ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }
    AnswerCityRegisterItem ans = 
            new AnswerCityRegisterItem(status, person,error);
    
    return ans;
    }
}
