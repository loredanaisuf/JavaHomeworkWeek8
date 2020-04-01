package ro.siit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class StudentsManagemet {
    private List<Student> students = new ArrayList<>();

    static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    public Integer getYear(String date){
        String[] spitDate = date.split("/");
        Integer year = 0;
        for(int i = 0; i<spitDate.length; i++){
            if(spitDate[i].length()==4)
                year = Integer.parseInt(spitDate[i]);
        }
        return year;
    }

    public void addStudent(String firstName, String lastName, String dateOfBirth, Character gender, String id) throws IllegalArgumentException{
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(firstName == null || firstName.equals("") ){
            logger.log(Level.ERROR, "first name should not be empty");
            throw new IllegalArgumentException("first name should not be empty");
        }

        if(lastName == null || lastName.equals("")){
            logger.log(Level.ERROR, "last name should not be empty");
            throw new IllegalArgumentException("last name should not be empty");
        }

        if((year - getYear(dateOfBirth)) < 18 || getYear(dateOfBirth) < 1900){
            logger.log(Level.ERROR, "date of birth between 1900 and current year - 18 ");
            throw new IllegalArgumentException("date of birth between 1900 and current year - 18 ");
        }
       if(Character.toLowerCase(gender) != 'f' && Character.toLowerCase(gender) != 'm'){
           logger.log(Level.ERROR, "last name should not be empty");
           throw new IllegalArgumentException("gender should be  (M and F), upper/lower case should both be accepted");
       }

        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
    }

    public void deleteStudent(String id) throws IllegalArgumentException{
        boolean ok = false;
        if(id == null || id.equals("")){
            logger.log(Level.ERROR, "The id shouldn't be empty ");
            throw new IllegalArgumentException("The id shouldn't be empty ");
        }

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
            logger.log(Level.ERROR, "The student with this id doesn't exist ");
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

    public List<Student> retrieveStudents(String age) throws IllegalArgumentException{
        int intAge;
        try{
            intAge = Integer.parseInt(age);
        }catch (NumberFormatException nfe){
            logger.log(Level.ERROR, "age is not a number ");
            throw new NumberFormatException("age is not a number");
        }

        if(intAge < 0){
            logger.log(Level.ERROR, "age should be greater than 0");
            throw new IllegalArgumentException("age should be greater than 0");
        }
        List<Student> auxStudents = new ArrayList<>();
        for(Student student : students){
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if(intAge == (year - getYear(student.getDateOfBirth()))){
                auxStudents.add(student);
            }
        }
        return auxStudents;
    }

    public Set<Student> sortedList(String type) throws IllegalArgumentException{

        switch (type){
            case("lastname"):
                Set<Student> sortedStudents = new TreeSet<>(new ComparatorByLastName());
                for(Student student : students){
                    sortedStudents.add(student);
                }
                return sortedStudents;
            case("birthdate"):
                sortedStudents = new TreeSet<>(new ComparatorByDateOfBirth());
                for(Student student : students){
                    sortedStudents.add(student);
                }
                return sortedStudents;
            default:
                logger.log(Level.ERROR, "The function argument must be \"lastname\" or \"birthdate\"");
                throw new IllegalArgumentException("The function argument must be \"lastname\" or \"birthdate\"");
        }

    }

}
