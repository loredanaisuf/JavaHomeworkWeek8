package ro.siit;



import java.util.Comparator;

public class ComparatorByLastName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getLastName().compareTo(student2.getLastName());
    }
}
