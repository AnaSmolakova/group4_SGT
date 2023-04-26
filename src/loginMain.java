import java.util.Scanner;

public class loginMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        loginInfo testUser = new loginInfo();
        System.out.println("Please, enter user name");
        testUser.setUsername(scanner.nextLine());

        System.out.println("Please, enter password");
        testUser.setPassword(scanner.nextLine());

        /*int userId = dataBase.checkLogin(testUser.getUsername(), testUser.getPassword());
        if (userId > 0) {
            System.out.println("You have logged in successfully!");
            testUser = userId;
        }*/
    }
}