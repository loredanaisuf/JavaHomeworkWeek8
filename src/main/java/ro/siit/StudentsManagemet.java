package ro.siit;

import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StudentsManagemet {
    private List<Student> students = new ArrayList<>();

    //static final Logger logger = LogManager.getLogger()

    public Integer getYear(String date){
        String[] spitDate = date.split("/");
        Integer year = 0;
        for(int i = 0; i<spitDate.length; i++){
            if(spitDate[i].length()==4)
                year = Integer.parseInt(spitDate[i]);
        }
        return year;
    }

    public void addStudent(String firstName, String lastName, String dateOfBirth, Character gender, String id) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(firstName == null || firstName.equals("") )
            throw new IllegalArgumentException("first name should not be empty");
        if(lastName == null || lastName.equals(""))
            throw new IllegalArgumentException("last name should not be empty");
        if((year - getYear(dateOfBirth)) < 18 || getYear(dateOfBirth) < 1900){
            throw new IllegalArgumentException("date of birth between 1900 and current year - 18 ");
        }
//        if(Character.toLowerCase(gender) != 'f' || Character.toLowerCase(gender) != 'm')
//            throw new IllegalArgumentException("gender should be  (M and F), upper/lower case should both be accepted");

        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
    }

    public void deleteStudent(String id){
        boolean ok = false;
        if(id == null || id.equals(""))
            throw new IllegalArgumentException("The id shouldn't be empty ");
        Student auxStudent = null;
        for(Student student : students){
            if(student.getId() == id) {
                auxStudent = student;
                ok = true;
            }
        }
        if(ok){
            students.remove(auxStudent);
        } else {
            throw new IllegalArgumentException("The student with this id doesn't exist");
        }

    }

    public List<Student> listOfStudents(){
        List<Student> auxStudents = new ArrayList<>();
        for(Student student : students){
            auxStudents.add(student);
        }
        return auxStudents;
    }

    public List<Student> retrieveStudents(Integer age){
        if(age < 0){
            throw new IllegalArgumentException("age should be greater than 0");
        }
        List<Student> auxStudents = new ArrayList<>();
        for(Student student : students){
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if(age == (year - getYear(student.getDateOfBirth()))){
                auxStudents.add(student);
            }
        }
        return auxStudents;
    }

    public Set<Student> sortedList(){
        Set<Student> sortedStudents = new TreeSet<>(new ComparatorByLastName());
        for(Student student : students){
            sortedStudents.add(student);
        }
        return sortedStudents;
    }

}
