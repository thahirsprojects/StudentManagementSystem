import Model.Admin;
import Model.Student;

import java.io.Console;
import java.util.*;

public class StudentManager{

    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        printArt();

        // sample students data
        Student student1 = new Student(123,"Arun", 19, "bca", "2023-2026");
        students.add(student1);
//        Student student2 = new Student(124,"Nakul", 21, "bca", "2023-2026");
//        Student student3 = new Student(125,"Kunal", 26, "b.tech", "2023-2027");
//        Student student4 = new Student(126,"Suhail", 20, "bsc cs", "2023-2026");
//        Student student5 = new Student(127,"Hasan", 19, "bsc it", "2023-2026");
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);

        // sample admin data
        Admin admin1 = new Admin("thahir","1a2b3c");
        admins.add(admin1);

        System.out.println("1) Admin\n2) Student\n");
        System.out.print("Enter your role : ");
        int role = scan.nextInt();
        scan.nextLine();

        switch (role) {
            case 1:
                boolean isAdmin = Auth.adminAuth();
                if(!isAdmin){
                    System.out.println("Permission denied !");
                    break;
                }
                while (isAdmin) {
                    System.out.println("\n1) Add new Student details\n2) Edit student details\n3) Delete student details\n4) View student details\n" +
                            "5) Manage Admin Accounts\n6) Exit");
                    System.out.print("\nEnter your choice : ");
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
                            System.out.println("\n1) View details by student RollNo\n2) View all students\n3) Back\n4) Exit");
                            System.out.print("\nEnter your choice : ");
                            int viewBy = scan.nextInt();
                            switch (viewBy) {
                                case 1:
                                    viewStudentByRollNo();
                                    break;
                                case 2:
                                    viewStudents();
                                    break;
                                case 3:
                                    break;
                                case 4 :
                                    return;
                            }
                            break;
                        case 5 :
                            System.out.println("\n1) View Admin Accounts\n2) Add Admins\n3) Remove Admin\n4) Back\n5) Exit");
                            System.out.print("\nEnter your choice : ");
                            int manage = scan.nextInt();
                            switch (manage) {
                                case 1:
                                    viewAdmin();
                                    break;
                                case 2:
                                    addAdmin();
                                    break;
                                case 3:
                                    removeAdmin();
                                    break;
                                case 4 :
                                    break;
                                case 5:
                                    return;
                            }
                            break;
                        case 6 :
                            isAdmin = false;
                            break;

                    }
                }
                break;
            case 2:
                boolean studentViewing = Auth.studentAuth();

                if (!studentViewing){
                    System.out.println("\nPermission Denied !\n");
                    break;
                }

                while (studentViewing) {
                    System.out.println("\n1) view details\n2) exit\n");
                    System.out.print("\nEnter you choice : ");
                    int studentChoice = scan.nextInt();

                    switch (studentChoice) {
                        case 1:
                            viewStudentByRollNo();
                            break;
                        case 2:
                            studentViewing = false;
                            break;
                    }
                }
                break;
        }
    }

    private static void removeAdmin() {
        System.out.println("\nREMOVE ADMIN\n");

        scan.nextLine();
        System.out.println("\nEnter username : ");
        String username = scan.nextLine();
        boolean found = false;

        for (Admin a : admins){
            if(Objects.equals(a.getUsername(), username)){
                admins.remove(a);
                found = true;
                System.out.println("\nAdmin removed !");
                break;
            }
        }

        System.out.println();
        if (!found) {
            System.out.println("\nInvalid Username : Admin Not Found !\n\n");
        }
    }

    private static void viewAdmin() {
        for (Admin a : admins){
            System.out.println(a);
        }
    }

    private static void viewStudentByRollNo() {
        System.out.println("\nSTUDENT :");
        int rollNo = getStudentRollNo();
        boolean found = false;
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.print("\nStudent found :"+ s+"\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nInvalid Id : Student Not Found !\n");
        }
    }

    private static void viewStudents() {
        System.out.println("\nSTUDENT LIST\n");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n");
    }

    private static void deleteStudent() {
        System.out.println("\nDELETE STUDENT\n");

        int studentToDelete = getStudentRollNo();
        boolean found = false;


        for (Student s : students){
            if(s.getRollNo()==studentToDelete){
                students.remove(s);
                found = true;
                System.out.println("\nStudent Deleted !");
                break;
            }
        }

        System.out.println();
        if (!found) {
            System.out.println("\nInvalid Id : Student Not Found !\n\n");
        }
    }

    private static void editStudent() {
        System.out.println("\nEdit STUDENT\n");
        int studentIdToEdit = getStudentRollNo();
        boolean found = false;
        for (Student s : students) {
            if (s.getRollNo() == studentIdToEdit) {
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
            System.out.println("Invalid RollNo : Student Not Found !\n\n");
        }
    }

    private static void addStudent() {
        System.out.println("\nADD STUDENT");
        scan.nextLine();
        System.out.print("Enter Roll No : ");
        int rollNo = scan.nextInt();

        for (Student s : students){
            if (s.getRollNo()==rollNo){
                System.out.println("\nRollNo Exists !");
                return;
            }
        }

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

        Student student = new Student(rollNo,name, age, course, batch);
        students.add(student);
        System.out.println("\nStudent Added Successfully...\n\n");
    }

    public static int getStudentRollNo() {
        System.out.print("Enter the student Rollno : ");
        return scan.nextInt();
    }

    public static void addAdmin(){
        System.out.print("\nEnter a user name for admin : ");
        String username = scan.nextLine();
        scan.nextLine();

        for (Admin a : admins){
            if (Objects.equals(a.getUsername(), username)) {
                System.out.println("USERNAME EXISTS !");
                return;
            }
        }

        System.out.print("Enter the Password : ");
        String password = scan.nextLine();

        Admin admin = new Admin(username,password);
        admins.add(admin);

        System.out.println("ADMIN ADDED SUCCESSFULLY ....\n");
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


