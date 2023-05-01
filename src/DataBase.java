import java.sql.*;
import java.util.Scanner;

public class DataBase {
    static String dbURL = "jdbc:mysql://localhost:3306/java35";
    static String user = "root";
    static String password = "1111";


    public int checkLogin(String userName, String pswd){

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
    public int createUser(String userName, String pswd, String fullName, String email){
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
        return  0;
    }

    public void readQuestions(String username){
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
                input = scanner.nextInt();
                if(resultSet.getInt(2)==1){
                    section1 += input;
                }else if(resultSet.getInt(2)==2){
                    section2 += input;
                }else if(resultSet.getInt(2)==3){
                    section3 += input;
                } else if (resultSet.getInt(2)==4) {
                    section4 += input;
                }
            }

            if(section1>section2 && section1>section3 && section1 > section4){
                System.out.println("Choleric Temperament");
            } else if (section2>section1 && section2>section3 && section2 > section4) {
                System.out.println("Sanguine Temperament");
            } else if (section3>section1 && section3>section2 && section3 > section4) {
                System.out.println("Melancholic Temperament");
            } else if (section4>section1 && section4>section2 && section4 > section3) {
                System.out.println("Phlegmatic Temperament");
            }




        }catch (Exception e){

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
