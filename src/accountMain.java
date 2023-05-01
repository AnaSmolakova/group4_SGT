import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accountMain {
    static DataBase db = new DataBase();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String response;
        do {
            System.out.println("Would you like to log in or create an account? (login/create)");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("login")) {
                scanner = new Scanner(System.in);
                System.out.println("Please enter your username:");
                String username = scanner.nextLine();
                System.out.println("Please enter your password:");
                String password = scanner.nextLine();


                int userId = db.checkLogin(username, password);
                if (userId > 0) {
                    System.out.println("Login successful. Welcome, user " + userId + "!");
                    db.readQuestions(username);
                } else {
                    System.out.println("Login failed. Please check your username and password and try again.");
                }
                break;
            } else if (response.equalsIgnoreCase("create")) {
                createAccount();
                break;
            } else {
                System.out.println("Invalid response. Please enter 'login' or 'create'.");
            }
        } while (true);
        scanner.close();
    }

    public static int login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();


        int userId = db.checkLogin(username, password);
        if (userId > 0) {
            System.out.println("Login successful. Welcome, user " + userId + "!");
        } else {
            System.out.println("Login failed. Please check your username and password and try again.");
        }
        return userId;
    }

    public static void createAccount() {
        String enteredUserName;
        String enteredPassword;
        String enteredFullName;
        String enteredEmail;
        Scanner scanner = new Scanner(System.in);
        String expectedUserName = "[A-Z]{3}[1-9]{3,20}";
        Pattern UserNamepattern = Pattern.compile(expectedUserName);
        Matcher matcher;
        do {
            System.out.println("Please, create new user name, which consists of 3 uppercase letter and at least 3 numbers. ");
            enteredUserName = scanner.nextLine();
            matcher = UserNamepattern.matcher(enteredUserName);
            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!matcher.matches());
        System.out.println("Input accepted.");
        String expectedPassword = "[1-9]{4,20}";
        Pattern Passwordpattern = Pattern.compile(expectedPassword);
        do {
            System.out.println("Please, create new password, which consists of 4 numbers.");
            enteredPassword = scanner.nextLine();
            matcher = Passwordpattern.matcher(enteredPassword);
            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!matcher.matches());
        System.out.println("Input accepted.");
        String expectedFullName = "[a-zA-Z]{1,20}+( )+[a-zA-Z]{1,20}";
        Pattern FullNamepattern = Pattern.compile(expectedFullName);
        do {
            System.out.println("Please, enter Your full name.");
            enteredFullName = scanner.nextLine();
            matcher = FullNamepattern.matcher(enteredFullName);
            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again. ");
            }
        } while (!matcher.matches());
        System.out.println("Input accepted.");
        String expectedEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern Emailpattern = Pattern.compile(expectedEmail);
        do {
            System.out.println("Please, enter Your email.");
            enteredEmail = scanner.nextLine();
            matcher = Emailpattern.matcher(enteredEmail);
            if (!matcher.matches()) {
                System.out.println("Your inputted email is not valid, please try one more time. ");
            }
        } while (!matcher.matches());

        int insertSuccessfull = db.createUser(enteredUserName, enteredPassword, enteredFullName, enteredEmail);
        if (insertSuccessfull > 0) {
            System.out.println(" Your account has been created! ");
        } else {
            System.out.println("Creation failed.");
        }
    }
}
