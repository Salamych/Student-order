package edu.javacourse.student_order;

import edu.javacourse.student_order.dao.StudentOrderDaoImpl;
import edu.javacourse.student_order.domain.StudentOrder;
import edu.javacourse.student_order.domain.children.AnswerChildren;
import edu.javacourse.student_order.domain.register.AnswerCityRegister;
import edu.javacourse.student_order.domain.student.AnswerStudent;
import edu.javacourse.student_order.domain.wedding.AnswerWedding;
import edu.javacourse.student_order.exception.DaoException;
import edu.javacourse.student_order.mail.MailSender;
import edu.javacourse.student_order.validator.ChildrenValidator;
import edu.javacourse.student_order.validator.CityRegisterValidator;
import edu.javacourse.student_order.validator.StudentValidator;
import edu.javacourse.student_order.validator.WeddingValidator;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        try {
            List<StudentOrder> soList = readStudentOrders();
            for (StudentOrder so : soList) {
                System.out.println("************************************************");
                checkOneOrder(so);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StudentOrder> readStudentOrders() throws DaoException {

        return new StudentOrderDaoImpl().getStudentOrders();
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding weddingAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }

}
