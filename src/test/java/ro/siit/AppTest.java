package ro.siit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddStudent1()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        try {
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'm', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'g', "2");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(1, testStudents.size(),0);
    }

    @Test
    public void testAddStudent2()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        try {
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'm', "1");
            studentsManagemet.addStudent("Isuf", null, "12/08/1998", 'f', "2");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(1, testStudents.size(),0);
    }

    @Test
    public void testAddStudent3()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        try {
            studentsManagemet.addStudent("", "Loredana", "12/08/1997", 'F', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(0, testStudents.size(),0);
    }

    @Test
    public void testAddStudent4()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        try {
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1800", 'F', "1");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(0, testStudents.size(),0);
    }
    @Test
    public void testAddStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        try {
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1950", 'F', "1");
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        List <Student> testStudents = new ArrayList<>();
        testStudents = studentsManagemet.listOfStudents();
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testRetrieveStudent1()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        List <Student> testStudents = new ArrayList<>();
        try{
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
            testStudents = studentsManagemet.retrieveStudents("-23");
        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        assertEquals(0, testStudents.size(),0);
    }

    @Test
    public void testRetrieveStudent2()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        List <Student> testStudents = new ArrayList<>();
        try{
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
            testStudents = studentsManagemet.retrieveStudents("-2f3");
        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        assertEquals(0, testStudents.size(),0);
    }

    @Test
    public void testRetrieveStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        List <Student> testStudents = new ArrayList<>();
        try{
            studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
            studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
            testStudents = studentsManagemet.retrieveStudents("23");
        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        assertEquals(1, testStudents.size(),0);
    }

    @Test
    public void testDeleteStudent1()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        List <Student> testStudents;
        try {
            studentsManagemet.deleteStudent(null);
            testStudents = new ArrayList<>();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        testStudents = studentsManagemet.listOfStudents();
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testDeleteStudent2()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        List <Student> testStudents;
        try {
            studentsManagemet.deleteStudent("");
            testStudents = new ArrayList<>();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        testStudents = studentsManagemet.listOfStudents();
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testDeleteStudent3()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        List <Student> testStudents;
        try {
            studentsManagemet.deleteStudent("3");
            testStudents = new ArrayList<>();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        testStudents = studentsManagemet.listOfStudents();
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testDeleteStudent()
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        List <Student> testStudents;
        try {
            studentsManagemet.deleteStudent("1");
            testStudents = new ArrayList<>();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        testStudents = studentsManagemet.listOfStudents();
        assertEquals(1, testStudents.size(),0);
    }

    @Test
    public void testListStudentsOrdered1(){
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        Set<Student> testStudents = new TreeSet<>();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        try{
            testStudents = studentsManagemet.sortedList("blabla");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, testStudents.size(),0);
    }

    @Test
    public void testListStudentsOrdered2(){
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        Set<Student> testStudents = new TreeSet<>();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        try{
            testStudents = studentsManagemet.sortedList("lastname");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, testStudents.size(),0);
    }

    @Test
    public void testListStudentsOrdered3(){
        StudentsManagemet studentsManagemet = new StudentsManagemet();
        Set<Student> testStudents = new TreeSet<>();
        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        try{
            testStudents = studentsManagemet.sortedList("birthdate");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, testStudents.size(),0);
    }
}
