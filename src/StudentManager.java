import java.util.*;

public class StudentManager {

    static List<Student> students = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        printArt();

        // sample students data
        Student student1 = new Student("Arun", 19, "bca", "2023-2026");
        Student student2 = new Student("Nakul", 21, "bca", "2023-2026");
        Student student3 = new Student("Kunal", 26, "b.tech", "2023-2027");
        Student student4 = new Student("Suhail", 20, "bsc cs", "2023-2026");
        Student student5 = new Student("Hasan", 19, "bsc it", "2023-2026");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("1) Admin\n2) Student\n");
        System.out.print("Enter your role : ");
        int role = scan.nextInt();

        switch (role) {
            case 1:
                boolean isAdmin = true;
                while (isAdmin) {
                    System.out.println("1) Add new Student details\n2) Edit student details\n3) Delete student details\n4) View tudent details\n" +
                            "5) Exit");
                    System.out.print("Enter your choice : ");
                    int adminChoice = scan.nextInt();
                    switch (adminChoice) {
                        case 1:
                            addStudent();
                            break;
                        case 2:
                            editStudent();
                            break;
                        case 3:
                            deleteStudent();
                            break;
                        case 4:
                            boolean viewStu = true;
                            System.out.println("1) View details by student Id\n2) View all students\n3) Exit");
                            System.out.println("Enter your choice : ");
                            int viewBy = scan.nextInt();
                            switch (viewBy) {
                                case 1:
                                    viewStudentById();
                                    break;
                                case 2:
                                    viewStudents();
                                    break;
                                case 3:
                                    viewStu = false;
                                    break;
                            }
                            break;
                        case 5:
                            isAdmin = false;
                            break;
                    }
                }
                break;
            case 2:
                boolean studentViewing = true;
                System.out.println("1) view details\n 2) exit");
                System.out.print("Enter you choice : ");
                int studentChoice = scan.nextInt();

                while (studentViewing) {

                    switch (studentChoice) {
                        case 1:
                            viewStudentById();
                            break;
                        case 2:
                            studentViewing = false;
                            break;
                    }
                }
                break;
        }
    }

    private static void viewStudentById() {
        System.out.println("STUDENT :");
        int id = getStudentId();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("\nStudent found :");
                found = true;
                System.out.println(s);
            }
        }
        if (!found) {
            System.out.println("\nInvalid Id : Student Not Found !\n\n");
        }
    }

    private static void viewStudents() {
        System.out.println("STUDENT LIST\n");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n\n");
    }

    private static void deleteStudent() {
        System.out.println("DELETE STUDENT\n");

        int studentIdToDelete = getStudentId();
        boolean found = false;

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == studentIdToDelete) {
                iterator.remove();
            }
        }
        System.out.println();
        if (!found) {
            System.out.println("\nInvalid Id : Student Not Found !\n\n");
        }
    }

    private static void editStudent() {
        System.out.println("Edit STUDENT\n");
        int studentIdToEdit = getStudentId();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == studentIdToEdit) {
                found = true;
                scan.nextLine();
                System.out.print("Enter name : ");
                String name = scan.nextLine();
                s.setName(name);
                System.out.print("Enter age : ");
                int age = scan.nextInt();
                s.setAge(age);
                scan.nextLine();
                System.out.print("Enter course : ");
                String course = scan.nextLine();
                s.setCourse(course);
                System.out.print("Enter Batch: ");
                String batch = scan.nextLine();
                s.setBatch(batch);

                System.out.println("\nStudent Edited Successfully...\n\n");
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid Id : Student Not Found !\n\n");
        }
    }

    private static void addStudent() {
        System.out.println("ADD STUDENT");
        scan.nextLine();
        System.out.print("Enter name : ");
        String name = scan.nextLine();
        System.out.print("Enter age : ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter course : ");
        String course = scan.nextLine();
        System.out.print("Enter Batch: ");
        String batch = scan.nextLine();

        Student student = new Student(name, age, course, batch);
        students.add(student);
        System.out.println("Generated STUDENT ID : "+student.getId());
        System.out.println("\nStudent Added Successfully...\n\n");
    }

    public static int getStudentId() {
        System.out.print("Enter the student id : ");
        return scan.nextInt();
    }

    private static void printArt() {
        System.out.println("/**\n" +
                " *   ____   _               _               _     __  __                                                            _   \n" +
                " *  / ___| | |_  _   _   __| |  ___  _ __  | |_  |  \\/  |  __ _  _ __    __ _   __ _   ___  _ __ ___    ___  _ __  | |_ \n" +
                " *  \\___ \\ | __|| | | | / _` | / _ \\| '_ \\ | __| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '_ ` _ \\  / _ \\| '_ \\ | __|\n" +
                " *   ___) || |_ | |_| || (_| ||  __/| | | || |_  | |  | || (_| || | | || (_| || (_| ||  __/| | | | | ||  __/| | | || |_ \n" +
                " *  |____/  \\__| \\__,_| \\__,_| \\___||_| |_| \\__| |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_| |_| |_| \\___||_| |_| \\__|\n" +
                " *   ____               _                                                      |___/                                    \n" +
                " *  / ___|  _   _  ___ | |_  ___  _ __ ___                                                                              \n" +
                " *  \\___ \\ | | | |/ __|| __|/ _ \\| '_ ` _ \\                                                                             \n" +
                " *   ___) || |_| |\\__ \\| |_|  __/| | | | | |                                                                            \n" +
                " *  |____/  \\__, ||___/ \\__|\\___||_| |_| |_|                                                                            \n" +
                " *          |___/                                                                                                       \n" +
                " */\n @thahirsprojects");
    }
}

