import java.util.Scanner;
public class Menu {
    public void exit() {
        System.out.println("Exiting Portal");
        System.exit(0);
    }
    public void showMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our Portal. Kindly login to continue\n");
        System.out.println("How would you like to Login?\n1: Faculty-member\n2: Student\n3: Exit");
        choice = sc.nextInt();
        Main m = new Main(choice);
    }
}
