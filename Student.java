import java.io.*;
import java.util.Scanner;

public class Student {

    public void viewCourses() {
        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            System.out.println("Available Courses:");
            while ((line = reader.readLine()) != null) {
                String[] courseDetails = line.split(",");
                System.out.println("Course Code: " + courseDetails[0]);
                System.out.println("Course Name: " + courseDetails[1]);
                System.out.println("Course Description: " + courseDetails[2]);
                System.out.println("-------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading courses.");
        }
    }

    public void enrollCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course code to enroll:");
        String courseCode = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            boolean courseFound = false;
            while ((line = reader.readLine()) != null) {
                String[] courseDetails = line.split(",");
                if (courseDetails[0].equals(courseCode)) {
                    System.out.println("Successfully enrolled in course: " + courseDetails[1]);
                    courseFound = true;
                    break;
                }
            }
            if (!courseFound) {
                System.out.println("Course with the given code not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading courses.");
        }
    }

    public void showPortalMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("________________________________________________________\n");
        System.out.println("\nYou are logged in successfully. Select an option:");
        System.out.println("1. View Courses");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Exit");
        System.out.print("________________________________________________________\n");

        int choice = sc.nextInt();
        if (choice == 1) {
            viewCourses();
            showPortalMenu();
        } else if (choice == 2) {
            enrollCourse();
            showPortalMenu();
        } else if (choice == 3) {
            System.out.println("Logging out");
        } else {
            System.out.println("Invalid choice");
            showPortalMenu();
        }
    }

}
