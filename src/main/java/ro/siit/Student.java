package ro.siit;

public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private char gender;
    private String id;

    public Student(String firstName, String lastName, String dateOfBirth, char gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public String getId(){
        return  id;
    }


    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", id='" + id + '\'' +
                '}';
    }
}
