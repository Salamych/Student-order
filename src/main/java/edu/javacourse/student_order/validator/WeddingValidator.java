
package edu.javacourse.student_order.validator;

import edu.javacourse.student_order.domain.StudentOrder;
import edu.javacourse.student_order.domain.wedding.AnswerWedding;

public class WeddingValidator {
   public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("CityRegister запущен!");
        return new AnswerWedding();
    }
}