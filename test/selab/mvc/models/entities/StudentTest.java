package selab.mvc.models.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void setName() throws Exception {
        Student student = new Student();
        student.setName("Keivan");
        assertEquals(student.getName(), "Keivan");
    }

}