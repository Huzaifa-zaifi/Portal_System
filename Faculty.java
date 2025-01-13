import java.io.*;
import java.util.Scanner;

public class Faculty {

    //? Creting Enrollment
    public void createCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course Name:");
        String courseName = sc.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = sc.nextLine();
        System.out.println("Enter Course Description:");
        String courseDescription = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt", true))) {
            writer.write(courseCode + "," + courseName + "," + courseDescription);
            writer.newLine();
            System.out.println("Course created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating course.");
        }
    }

    //? Showing all students
    public void showAllStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            System.out.println("List of all students:");
            while ((line = reader.readLine()) != null) {
                String[] studentDetails = line.split(",");
                System.out.println("Username: " + studentDetails[0]);
            }
        } catch (IOException e) {
            System.out.println("Error reading students.");
        }
    }

    public void showF(){
        Scanner sc = new Scanner(System.in);
        Faculty faculty = new Faculty();

        while (true) {
            
            System.out.println("\nFaculty Portal Menu:");
            System.out.println("1. Create a Course");
            System.out.println("2. Show all the students");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                faculty.createCourse();
            } else if (choice == 2) {
                faculty.showAllStudents();
            } else {
                System.out.println("Exiting Faculty Portal");
                break;
            }
        }
    }
}
