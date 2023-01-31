package edu.javacourse.student_order.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.Test;

public class SimpleRunner {

    public static void main(String[] args) {
        SimpleRunner sr = new SimpleRunner();

        sr.runTests();
    }

    private void runTests() {
        try {
            Class cl = Class.forName("edu.javacourse.student_order.dao.DictionaryDaoImplTest");

            Constructor cst = cl.getConstructor();
            Object entity = cst.newInstance();

            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                Test ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
