import java.util.Scanner;

public class Menu {

    public void exit() {
        clearScreen();
        System.out.println("Exiting Portal");
        System.exit(0);
    }

    public void showMenu() {
        clearScreen();
        int choice;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Welcome to our Portal. Kindly login to continue\n");
        System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("How would you like to Login?\n1: Faculty-member\n2: Student\n3: Exit");
        System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        choice = sc.nextInt();
        Main m = new Main(choice);
    }

    //? From internet
    public void clearScreen() {
        
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // Windows specific
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Unix-based systems (Linux, macOS, etc.)
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
