import java.io.*;
import java.util.Scanner;

public class PortalLogin {

    //? sign-up
    public void studentSignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write(username + "," + password);  
            writer.newLine();  
            System.out.println("Student sign-up successful!");
        } catch (IOException e) {
            System.out.println("Error during sign-up");
        }
    }

    //? slogin
    public void studentLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    System.out.println("Student login successful!");
                    Student student = new Student();
                    student.showPortalMenu();
                    return; 
                }
            }
            System.out.println("Invalid username or password");
        } catch (IOException e) {
            System.out.println("Error during login.");
        }
    }

    //? sign-up
    public void facultySignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your faculty ID:");
        String fId = sc.nextLine();
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("faculty.txt", true))) {
            writer.write(fId + "," + username + "," + password);
            writer.newLine();
            System.out.println("Faculty sign-up successful!");
        } catch (IOException e) {
            System.out.println("Error during faculty sign-up.");
        }
    }

    //? login
    public void facultyLogin() {
        Scanner sc = new Scanner(System.in);
        String username,password;
               
        System.out.println("Enter your username:");
        username = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextLine();
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader("faculty.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[1].equals(username) && userDetails[2].equals(password)) {
                    System.out.println("Faculty login successful!");
                    Faculty faculty = new Faculty();
                    faculty.showF();
                    return;  
                }
            }
            System.out.println("Invalid username or password.");
        } catch (IOException e) {
            System.out.println("Error during faculty login.");
        }
    }
}



    
       