import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SecureCode {

public static void main(String[] args) {
    String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    String username = "admin";
    String password = "password123";

    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter username:");
        String userInput = scanner.nextLine();

        String query = "SELECT * FROM users WHERE username = ?";

        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userInput);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Welcome, " + resultSet.getString("username") + "!");
        } else {
            System.out.println("User not found.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
