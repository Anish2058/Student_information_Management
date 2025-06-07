import java.util.Scanner;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student_Database dao=new Student_Database();
        Scanner scanner=new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n --------------------STUDENT RECORD MANAGEMENT------------------------\n\n");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            System.out.println("Enter Choice:");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.print("Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Age : ");
                    int age = scanner.nextInt();
                    dao.addStudent(new Student(name, age));
                }
                case 2 ->{
                    System.out.println("ID\tName\t\t\tAge");
                    List<Student> list = dao.getAllStudents();
                    for (Student s : list) {
                        System.out.println(s.getId() + "\t " + s.getName() + "\t" + s.getAge() + "\t");
                    }
                }

                case 3 -> {
                    System.out.print("ID to update: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Age: ");
                    int age = scanner.nextInt();
                    dao.updateStudent(new Student(id, name, age));
                }

                case 4-> {
                    System.out.print("ID to delete: ");
                    int id = scanner.nextInt();
                    dao.deleteStudent(id);
                }

                case 0 -> {
                    System.out.println("Program Executed Successfully");
                }

                default -> System.out.println("Invalid Choice");
            }

        }while (choice!=0);
    }
}