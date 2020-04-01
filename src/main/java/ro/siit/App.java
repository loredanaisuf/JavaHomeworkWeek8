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

        studentsManagemet.addStudent("Isuf", "Loredana", "12/08/1999", 'f', "1");
        studentsManagemet.addStudent("Isuf", "Ionela", "12/08/1998", 'F', "2");
        System.out.println("List of students:");
        System.out.println(studentsManagemet.listOfStudents());
        System.out.println("Sorted list: ");
        try{
            System.out.println(studentsManagemet.sortedList("birthdate"));
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        System.out.println("List of retrieves students");
        System.out.println(studentsManagemet.retrieveStudents("23"));
        studentsManagemet.deleteStudent("2");
        System.out.println("List of students after delete");
        System.out.println(studentsManagemet.listOfStudents());

    }
}
