package ro.siit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentsManagemet studentsManagemet = new StudentsManagemet();

        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1997", 'F', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        System.out.println("List of students:");
        System.out.println(studentsManagemet.listOfStudents());
        System.out.println("Sorted list: ");
        System.out.println(studentsManagemet.sortedList());
        System.out.println("List of retrieves students");
        System.out.println(studentsManagemet.retrieveStudents(23));
        studentsManagemet.deleteStudent("2");
        System.out.println("List of students after delete");
        System.out.println(studentsManagemet.listOfStudents());

    }
}
