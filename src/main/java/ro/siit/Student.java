package ro.siit;

public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private char gender;
    private int id;

    public Student(String firstName, String lastName, String dateOfBirth, char gender, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public int getId(){
        return  id;
    }

    public Integer getYear(String date){
        String[] spitDate = date.split("/");
        Integer year = 0;
        for(int i = 0; i<spitDate.length; i++){
            if(spitDate[i].length()==4)
                year = Integer.parseInt(spitDate[i]);
        }
        return year;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
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
