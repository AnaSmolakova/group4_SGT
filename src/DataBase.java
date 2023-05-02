import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DataBase {
    static String dbURL = "jdbc:mysql://localhost:3306/java35";
    static String user = "root";
    static String password = "1111";


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

            // Retrieve the ID of the newly created user
            String selectSql = "SELECT userID FROM logininfo WHERE username = ? AND password = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setString(1, userName);
            selectStatement.setString(2, pswd);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void readQuestions(String username) {
        System.out.println(" Please evaluate yourself according to the following characteristics");
        System.out.println("1 = “That is definitely NOT me”;+\n" +
                "\'2 = “That is usually NOT me” +\n" +
                "\'3= “That is usually me”;+\n" +
                "\'4 = “That is mostly me”;\n" +
                "\'5 = “That is mostly me.” \\n");
        int section1 = 0;
        int section2 = 0;
        int section3 = 0;
        int section4 = 0;

        Scanner scanner = new Scanner(System.in);
        int input;

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM psychologytest";
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
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
                    switch (resultSet.getInt(2)) {
                        case 1:
                            section1 += input;
                            break;
                        case 2:
                            section2 += input;
                            break;
                        case 3:
                            section3 += input;
                            break;
                        case 4:
                            section4 += input;
                            break;
                    }
                }
            }

            //Insert the section scores into the "testResults" table for the user
            String insertSql = "INSERT INTO testResults (userID, choleric, sanguine, melancholic, phlegmatic) " +
                    "VALUES ((SELECT userID FROM loginInfo WHERE username = ?), ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                insertStatement.setString(1, username);
                insertStatement.setInt(2, section1);
                insertStatement.setInt(3, section2);
                insertStatement.setInt(4, section3);
                insertStatement.setInt(5, section4);
                insertStatement.executeUpdate();
            }

            if (section1 > section2 && section1 > section3 && section1 > section4) {
                System.out.println("Your temperament is choleric");
            } else if (section2 > section1 && section2 > section3 && section2 > section4) {
                System.out.println("Your temperament is sanguine");
            } else if (section3 > section1 && section3 > section2 && section3 > section4) {
                System.out.println("Your temperament is melancholic");
            } else if (section4 > section1 && section4 > section2 && section4 > section3) {
                System.out.println("Your temperament is phlegmatic");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LocalDate date = LocalDate.now();
            // Prepare the SQL statement to insert the test result
        }
    }


    public void saveTestResult(int userID, int questionID) {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            // Get the current date
            LocalDate date = LocalDate.now();

            // Prepare the SQL statement to insert the test result
            String sql = "INSERT INTO testResult WHERE userIDInfo =' " + userID + " ' questionIDInfo =' " + questionID + " ' and testDate ='" + date;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, questionID);
            pstmt.setObject(3, date);

            // Execute the SQL statement
            pstmt.executeUpdate();

            System.out.println("Test result saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*public static int checklogin() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            // Prompt the user to enter their login information
            System.out.println("Please enter your login information:");

            // Prompt for the username and password
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine();
            System.out.print("Password: ");
            String passwordInput = scanner.nextLine();

            // Check if the user exists in the database
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM loginInfo WHERE username = ? AND password = ?")) {
                stmt.setString(1, usernameInput);
                stmt.setString(2, passwordInput);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // User exists, get their userID
                        userID = rs.getInt("userID");
                    } else {
                        // User does not exist, create a new one
                        try (PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO loginInfo (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                            stmt2.setString(1, usernameInput);
                            stmt2.setString(2, passwordInput);

                            stmt2.executeUpdate();

                            try (ResultSet generatedKeys = stmt2.getGeneratedKeys()) {
                                if (generatedKeys.next()) {
                                    userID = generatedKeys.getInt(1);
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
        }

    }*/

 /*public static void getQuestion() throws SQLException{

        // Get the questions from the database and prompt the user to answer them
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM psychologytest ORDER BY questionID")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int questionID = rs.getInt("questionID");
                    String question = rs.getString("question");

                    System.out.print(question + " (1 = disagree, 2 = somewhat disagree, 3 = neutral, 4 = somewhat agree, 5 = agree): ");
                    int answer = scanner.nextInt();

                    try (PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO result (userIDInfo, questionIDInfo, answer) VALUES (?, ?, ?)")) {
                        stmt2.setInt(1, userID);
                        stmt2.setInt(2, questionID);
                        stmt2.setInt(3, answer);

                        stmt2.executeUpdate();
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }*/
}
