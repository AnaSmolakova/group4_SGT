import java.util.Scanner;
import java.sql.*;
public class DataBase {
    String dbURL = "jdbc:mysql://localhost:3306/java35";
    String user = "root";
    String password = "1111";

    public int checkLogin(String userName, String password) {

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM loginInfo WHERE username ='" + userName + "' and password ='" + password + "'";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                //returns current Users ID Nr.
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public class DataBase1 {
        public static void main(String[] args) {
            String dbURL = "jdbc:mysql://localhost:3306/java35";
            String username = "root";
            String password = "1111";
            Scanner scanner = new Scanner(System.in);
            char again = 'y';
        }
    }
}
