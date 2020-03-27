package ro.siit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentsManagemet {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String dateOfBirth, char gender, int id){
        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
    }

    public void deleteStudent(int id){
        Student auxStudent = null;
        for(Student student : students){
            if(student.getId() == id) {
                auxStudent = student;
            }
        }
        students.remove(auxStudent);
    }

    public List<Student> listOfStudents(){
        List<Student> auxStudents = new ArrayList<>();
        for(Student student : students){
            auxStudents.add(student);
        }
        return auxStudents;
    }

    public List<Student> retrieveStudents(Integer age){
        List<Student> auxStudents = new ArrayList<>();
        for(Student student : students){
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if(age == (year - student.getYear(student.getDateOfBirth()))){
                auxStudents.add(student);
            }
        }
        return auxStudents;
    }

}
