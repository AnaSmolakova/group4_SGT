import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountMain {

    public static void main(String[] args){
        Pattern pattern = Pattern.compile("abc");
        Matcher matcher = pattern.matcher("abc");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, create new user name, which consists of 3 uppercase letter and at least 3 numbers. ");
        String newUserName = scanner.nextLine();
        if (Pattern.matches("[A-Z]{3}[1-9]{3,20}", newUserName)) {
            System.out.println("Your inputted user name is valid");
        } else {
            System.out.println("Your inputted user name is not valid, please try one more time.");
        }

        System.out.println("Please, create new password, which consists of 4 numbers.");
        String newUserPassword = scanner.nextLine();
        if (Pattern.matches("[1-9]{4,20}", newUserPassword)) {
            System.out.println("Your inputted password is valid");
        } else {
            System.out.println("Your inputted password is not valid, please try one more time.");
        }

        System.out.println("Please, enter Your full name.");
        String newUserFullName = scanner.nextLine();
        if (Pattern.matches("[a-zA-Z]{1,20}+(\s)+[a-zA-Z]{1,20}", newUserFullName)) {
            System.out.println("Your inputted full name is valid");
        } else {
            System.out.println("Your inputted full name is not valid, please try one more time. ");
        }

        System.out.println("Please, enter Your email.");
        String newEmail = scanner.nextLine();
        if (Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", newEmail)) {
            System.out.println("Your inputted email is valid");
        } else {
            System.out.println("Your inputted email is not valid, please try one more time. ");
        }
    }
}


