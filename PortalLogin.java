import java.io.*;
import java.util.Scanner;

public class PortalLogin {

    public void studentSignUp() {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("********************************************************\n");
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        System.out.println("********************************************************\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Student sign-up successful!");
        } catch (IOException e) {
            System.out.println("Error during sign-up");
        }
    }

    public void studentLogin() {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("********************************************************\n");
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        System.out.println("********************************************************\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    System.out.println("Student login successful!");
                    Student student = new Student();
                    student.showPMenu();  
                    return;  
                }
            }
            System.out.println("Invalid username or password");
        } catch (IOException e) {
            System.out.println("Error during login.");
        }
    }

    public void facultySignUp() {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("********************************************************\n");
        System.out.println("Enter your faculty ID:");
        String fId = sc.nextLine();
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        System.out.println("********************************************************\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("faculty.txt", true))) {
            writer.write(fId + "," + username + "," + password);
            writer.newLine();
            System.out.println("Faculty sign-up successful!");
        } catch (IOException e) {
            System.out.println("Error during faculty sign-up.");
        }
    }

    public void facultyLogin() {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        String username, password;
        System.out.println("********************************************************\n");
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

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }
}
