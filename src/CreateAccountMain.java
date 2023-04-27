package project;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expectedUserName = "[A-Z]{3}[1-9]{3,20}";
        Pattern UserNamepattern = Pattern.compile(expectedUserName);
        String enteredUserName;
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
        String enteredPassword;
        Matcher Passwordmatcher;
        do {
            System.out.println("Please, create new password, which consists of 4 numbers.");
            enteredPassword = scanner.nextLine();
            matcher = Passwordpattern.matcher(enteredPassword);
            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!matcher.matches());
        System.out.println("Input accepted.");

        String expectedFullName = "[a-zA-Z]{1,20}+(\s)+[a-zA-Z]{1,20}";
        Pattern FullNamepattern = Pattern.compile(expectedFullName);
        String enteredFullName;
        Matcher FullNamematcher;
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
        String enteredEmail;
        Matcher Emailmatcher;

        do {
            System.out.println("Please, enter Your email.");
            enteredEmail = scanner.nextLine();
            matcher = Emailpattern.matcher(enteredEmail);
            if (!matcher.matches()) {
                System.out.println("Your inputted email is not valid, please try one more time. ");
            }
        } while (!matcher.matches());
        System.out.println("Input accepted.");


        System.out.println("Please, enter Your email.");
        String newEmail = scanner.nextLine();
        if (Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", newEmail)) {
            System.out.println("Your inputted email is valid");
        } else {
            System.out.println("Invalid input. Please try again. ");
        }
    }
    public class choice {
        public static void main(String[] args) {
            String response;
            Scanner scanner;
            do {
                System.out.println("Would you like to log in or create an account? (login/create)");
                scanner = new Scanner(System.in);
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("login")) {
                    login();
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
        private static void login() {
            System.out.println("You have successfully logged in!");
        }
        private static void createAccount() {
            System.out.println("Your account has been created!");
        }
    }
}
