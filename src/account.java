import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class account {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String response;
            do {
                System.out.println("Would you like to log in or create an account? (login/create)");
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
        private static void createAccount() {
            CreateAccountMain account = new CreateAccountMain();
            account.main(null);
        }
        public static void login() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            DataBase db = new DataBase();
            int userId = db.checkLogin(username, password);
            if (userId > 0) {
                System.out.println("Login successful. Welcome, user " + userId + "!");
            } else {
                System.out.println("Login failed. Please check your username and password and try again.");
            }
        }
        static class CreateAccountMain {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String expectedUserName = "[A-Z]{3}[1-9]{3,20}";
                Pattern UserNamepattern = Pattern.compile(expectedUserName);
                Matcher matcher;
                do {
                    System.out.println("Please, create new user name, which consists of 3 uppercase letter and at least 3 numbers. ");
                    String enteredUserName = scanner.nextLine();
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
                    String enteredPassword = scanner.nextLine();
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
                    String enteredFullName = scanner.nextLine();
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
                    String enteredEmail = scanner.nextLine();
                    matcher = Emailpattern.matcher(enteredEmail);
                    if (!matcher.matches()) {
                        System.out.println("Your inputted email is not valid, please try one more time. ");
                    }
                } while (!matcher.matches());
                System.out.println(" Your account has been created! ");
            }
        }
    }

