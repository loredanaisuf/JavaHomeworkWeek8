package ro.siit;

import java.util.Comparator;

public class ComparatorByDateOfBirth implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getDateOfBirth().compareTo(student2.getDateOfBirth());
    }
}
