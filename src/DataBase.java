import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DataBase {
    static String dbURL = "jdbc:mysql://localhost:3306/java35";
    static String user = "root";
    static String password = "0705";


    public int checkLogin(String userName, String pswd) {

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM loginInfo WHERE username ='" + userName + "' and password ='" + pswd + "'";

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

    public int createUser(String userName, String pswd, String fullName, String email) {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "INSERT INTO logininfo (username, password, fullName, email) VALUES (?,?,?,?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pswd);
            preparedStatement.setString(3, fullName);
            preparedStatement.setString(4, email);
            preparedStatement.executeUpdate();


            //to get the ID of the current user
            String sqlID = "SELECT * FROM logininfo WHERE username ='" + userName + "' and password ='" + pswd + "'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlID);


            if (resultSet.next()) {
                return resultSet.getInt(1);//returns current users ID Nr.
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void readQuestions(String username) {
        int section1 = 0;
        int section2 = 0;
        int section3 = 0;
        int section4 = 0;
        Scanner scanner = new Scanner(System.in);
        int input;
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM psychologytest";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
                while (true) {
                    try {
                        input = scanner.nextInt();
                        if (input < 1 || input > 5) {
                            System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        scanner.nextLine(); // clear the input buffer
                    }
                }
                if (resultSet.getInt(2) == 1) {
                    section1 += input;
                } else if (resultSet.getInt(2) == 2) {
                    section2 += input;
                } else if (resultSet.getInt(2) == 3) {
                    section3 += input;
                } else if (resultSet.getInt(2) == 4) {
                    section4 += input;
                }
            }
            //Insert the section scores into the "testResults" table for the user
            String insertSql = "INSERT INTO testResults (userID, section1, section2, section3, section4) " +
                    "VALUES ((SELECT userID FROM loginInfo WHERE username = ?), ?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);
            insertStatement.setString(1, username);
            insertStatement.setInt(2, section1);
            insertStatement.setInt(3, section2);
            insertStatement.setInt(4, section3);
            insertStatement.setInt(5, section4);
            insertStatement.executeUpdate();

            if (section1 > section2 && section1 > section3 && section1 > section4) {
                System.out.println("Choleric Temperament");
            } else if (section2 > section1 && section2 > section3 && section2 > section4) {
                System.out.println("Your temperament is sanguine");
            } else if (section3 > section1 && section3 > section2 && section3 > section4) {
                System.out.println("Your temperament is melancholic");
            } else if (section4 > section1 && section4 > section2 && section4 > section3) {
                System.out.println("Your temperament is phlegmatic");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}