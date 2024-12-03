
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableCode {

    public static void main(String[] args) {
        // Hardcoded credentials (vulnerability)
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "admin";
        String password = "password123";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter username:");
            String userInput = scanner.nextLine();

            // Vulnerable SQL query (SQL Injection)
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

            // Establishing database connection
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();

            // Executing the vulnerable query
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Welcome, " + resultSet.getString("username") + "!");
            } else {
                System.out.println("User not found.");
            }

        } catch (Exception e) {
            // Generic exception handling (vulnerability)
            e.printStackTrace();
        }
    }
}

