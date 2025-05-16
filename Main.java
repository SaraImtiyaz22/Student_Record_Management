import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.createTable();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    dao.addStudent(new Student(roll, name, age, course));
                    break;

                case 2:
                    for (Student s : dao.getAllStudents()) {
                        System.out.println("Roll: " + s.getRollNo() + ", Name: " + s.getName() +
                                ", Age: " + s.getAge() + ", Course: " + s.getCourse());
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    dao.updateStudent(new Student(updateRoll, newName, newAge, newCourse));
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int deleteRoll = sc.nextInt();
                    dao.deleteStudent(deleteRoll);
                    break;

                case 5:
                sc.close();
                    System.out.println("Goodbye!");
                    return;
                    
            }
        }
    }
}
