import java.io.*;
import java.util.Scanner;

public class Faculty {

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

    public void showAllStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            int i = 1;
            System.out.println("List of all students:");
            while ((line = reader.readLine()) != null) {
                String[] studentDetails = line.split(",");
                System.out.println("Student " + i + ": " + studentDetails[0]);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error reading students.");
        }
    }

    public void markAttendance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course code for marking attendance:");
        String courseCode = sc.nextLine();
        System.out.println("Enter the student name for marking attendance:");
        String studentName = sc.nextLine();
        System.out.println("Enter attendance percentage for the student (0-100):");
        int attendance = sc.nextInt();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentName + "_attendance.txt", true))) {
            writer.write(courseCode + "," + attendance);
            writer.newLine();
            System.out.println("Attendance marked successfully for " + studentName);
        } catch (IOException e) {
            System.out.println("Error marking attendance.");
        }
    }

    public void showF() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("________________________________________________________\n");
            System.out.println("\nFaculty Portal Menu:");
            System.out.println("1. Create a Course");
            System.out.println("2. Show all the students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Exit");
            System.out.print("________________________________________________________\n");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                createCourse();
            } else if (choice == 2) {
                showAllStudents();
            } else if (choice == 3) {
                markAttendance();
            } else {
                System.out.println("Exiting Faculty Portal");
                break;
            }
        }
    }
}
