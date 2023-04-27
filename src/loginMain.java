import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.util.Scanner;

public class loginMain {


    static DataBase db = new DataBase();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        loginInfo testUser = new loginInfo();
        System.out.println("Please, enter the user name. ");
        testUser.setUsername(scanner.nextLine());

        System.out.println("Please, enter the password. ");
        testUser.setPassword(scanner.nextLine());

        int userId = db.checkLogin(testUser.getUsername(), testUser.getPassword());
        if (userId > 0) {
            System.out.println("You have logged in successfully!");
        }else{
            System.out.println("Login error");
        }
    }
}
