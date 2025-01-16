import java.io.*;
import java.util.Scanner;

public class Student {

    
    public void viewCourses() {
        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line = reader.readLine();
            System.out.println("Available Courses:");
            while (line != null) {
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
            String line = reader.readLine();
            boolean courseFound = false;
            while (line != null) {
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

    
    public void withdrawCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course code to withdraw from:");
        String courseCode = sc.nextLine();

       
        try {
            File tempFile = new File("temp_courses.txt");
            BufferedReader reader = new BufferedReader(new FileReader("courses.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line=reader.readLine();

            while (line != null) {
                String[] courseDetails = line.split(",");
                if (!courseDetails[0].equals(courseCode)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();

            System.out.println("Successfully withdrawn from course with code: " + courseCode);
        } catch (IOException e) {
            System.out.println("Error withdrawing from course");
        }
    }

    
    public void viewAttendance(String studentName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(studentName + "_attendance.txt"))) {
            String line=reader.readLine();
            System.out.println("Attendance for " + studentName + ":");
            while (line != null) {
                String[] attendanceDetails = line.split(",");
                String courseCode = attendanceDetails[0];
                int attendance = Integer.parseInt(attendanceDetails[1]);
                String status = attendance >= 90 ? "Good" : attendance >= 80 ? "Moderate" : "Bad";
                System.out.println("Course Code: " + courseCode + ", Attendance: " + attendance + "%, Status: " + status);
            }
        } catch (IOException e) {
            System.out.println("Error reading attendance.");
        }
    }

    public void showPortalMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("________________________________________________________\n");
        System.out.println("\nYou are logged in successfully. Select an option:");
        System.out.println("1. View Courses");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Withdraw from a Course");
        System.out.println("4. View Attendance");
        System.out.println("5. Exit");
        System.out.print("________________________________________________________\n");

        int choice = sc.nextInt();
        if (choice == 1) {
            viewCourses();
            showPortalMenu();
        } else if (choice == 2) {
            enrollCourse();
            showPortalMenu();
        } else if (choice == 3) {
            withdrawCourse();
            showPortalMenu();
        } else if (choice == 4) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter your name to view attendance:");
            String studentName = sc2.nextLine();
            viewAttendance(studentName);
            showPortalMenu();
        } else if (choice == 5) {
            System.out.println("Logging out");
        } else {
            System.out.println("Invalid choice");
            showPortalMenu();
        }
    }
}
