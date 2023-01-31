
package edu.javacourse.student_order.validator;

import edu.javacourse.student_order.domain.StudentOrder;
import edu.javacourse.student_order.domain.children.AnswerChildren;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running!");
        return new AnswerChildren();
    }
}

