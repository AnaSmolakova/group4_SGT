
/*import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String dbURL = "https://github.com/AnaSmolakova/group4_SGT/tree/main/SQL";
        String username = "???";
        String password = "???";
        Scanner scanner = new Scanner(System.in);
        char again = 'y';

        try (
                Connection conn = DriverManager.getConnection(dbURL)) {
            System.out.println("Connected to database!");

            while (again == 'y') {
                System.out.println("Welcome to the TEMPERAMENT TEST code. Would you like to take a TEMPERAMENT TESTS?"
                        "Please choose which version of test you would like to take: " +
                                "short test (S) or full test (F)");
                System.out.println("s - demo version - short test");
                System.out.println("f - full test");
                System.out.println("d - make an appointment to doctor");

                char action = scanner.nextLine().charAt(0);

            } else{
                System.out.println("Invalid input");
            }


            System.out.println("Do you want to do smth more? y/n");
            again = scanner.nextLine().charAt(0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

 */
