import Model.Admin;
import Model.Student;

import java.util.Objects;
import java.util.Scanner;

public class Auth {

    static Scanner scan = new Scanner(System.in);


    public static boolean adminAuth(){

        System.out.print("\nEnter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter the Password : ");
        String password = scan.nextLine();

        for (Admin a : StudentManager.admins){
            if(Objects.equals(a.getUsername().toLowerCase(), username.toLowerCase()) &&
                    Objects.equals(a.getPassword(), password)){
                return true;
            }
        }
        return false;
    }

    static Boolean studentAuth() {

        System.out.print("\nEnter Your Name : ");
        String name = scan.nextLine();
        System.out.print("\nEnter your Roll No : ");
        int rollNo = scan.nextInt();

        for (Student s : StudentManager.students){
            if(Objects.equals(s.getName().toLowerCase(), name.toLowerCase()) &&
                    Objects.equals(s.getRollNo(), rollNo)){
                System.out.println("\n"+s);
                return true;
            }
        }
        return false;
    }
}
