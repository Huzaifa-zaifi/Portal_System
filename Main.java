import java.util.Scanner;

public class Main {

    Main(int choice) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (choice == 1) {
                int option = 0;
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                System.out.println("Choose an option\n1: Faculty-member signup\n2: Faculty login\n3: Back");
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                option = sc.nextInt();
                if (option == 1) {
                    new PortalLogin().facultySignUp();
                    menu.showMenu();
                } else if (option == 2) {
                    new PortalLogin().facultyLogin();
                    menu.showMenu();
                } else {
                    menu.showMenu();
                }
            } else if (choice == 2) {
                int option = 0;
                while (true) {
                    System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                    System.out.println("Choose an option\n1: Student-signup\n2: Student-Login\n3: Back");
                    System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                    option = sc.nextInt();
                    if (option == 1) {
                        new PortalLogin().studentSignUp();
                        menu.showMenu();
                    } else if (option == 2) {
                        new PortalLogin().studentLogin();
                        menu.showMenu();
                    } else {
                        menu.showMenu();
                    }
                }
            } else if (choice == 3) {
                menu.exit();
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();  
    }
}
