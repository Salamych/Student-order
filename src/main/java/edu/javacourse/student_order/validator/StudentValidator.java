
package edu.javacourse.student_order.validator;

import edu.javacourse.student_order.domain.StudentOrder;
import edu.javacourse.student_order.domain.student.AnswerStudent;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются!");
        return new AnswerStudent();
    }
}
