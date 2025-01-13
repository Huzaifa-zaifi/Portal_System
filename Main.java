import java.util.Scanner;

public class Main {
    Main(int c){
        Menu menu = new Menu();
        while(true){
        Scanner sc = new Scanner(System.in);
        PortalLogin portal = new PortalLogin();
        if(c == 1){
            int choice = 0;
            System.out.println("Choose an option\n1: Faculty-member signup\n2: Faculty login\n3: Back");
            choice = sc.nextInt();
            if(choice == 1){
                portal.facultySignUp();
                menu.showMenu();
            }
            else if(choice == 2){
                portal.facultyLogin();
                menu.showMenu();
            }
            else{
                menu.showMenu();
            }
        }
        else if(c == 2){
            int choice = 0;
            while(true){
            System.out.println("Choose an option\n1: Student-signup\n2: Student-Login\n3: Back");
            choice = sc.nextInt();
            if(choice == 1){
                portal.studentSignUp();
                menu.showMenu();
            }
            else if(choice == 2){
                portal.studentLogin();
                menu.showMenu();
            }
            else{
                menu.showMenu();
            }
            }
        }
        else if(c == 3){
            menu.exit();
        }
    }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
    }
}
