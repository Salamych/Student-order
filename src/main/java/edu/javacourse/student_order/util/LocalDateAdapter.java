
package edu.javacourse.student_order.util;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

     private static final String PATTERN = "dd.MM.yyyy";
     
    @Override
    public LocalDate unmarshal(String vt) throws Exception {
        return LocalDate.parse(vt, DateTimeFormatter.ofPattern(PATTERN));
    }

    @Override
    public String marshal(LocalDate bt) throws Exception {
        return bt.format(DateTimeFormatter.ofPattern(PATTERN));
    }
   

}
