package ro.siit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', 1);
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', 2);
        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testRetrieveStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', 1);
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', 2);
        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.retrieveStudents(23);
        assertEquals(1, testStudents.size(),0);
    }

    @Test
    public void testDeleteStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', 1);
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', 2);
        studentsManagemet.deleteStudent(1);
        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(1, testStudents.size(),0);
    }
}
