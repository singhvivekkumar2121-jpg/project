import java.sql.*;
import java.util.Scanner;
public class AuthService {
    public static boolean login() {
        try  {
//            System.out.print("Enter Username: ");
            String username = InutHelper.readInt("Enter username");
//            System.out.print("Enter Password: ");
            String password = InutHelper.readInt("Enter password");
            String query = "SELECT * FROM admins WHERE username=? AND password=?";


            System.out.println("Trying to connect" + username + password);

            try (Connection conn = Database.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("\nLogin Successful! Welcome Admin.\n");
                    return true;
                } else {
                    System.out.println("\nInvalid Login! Try Again.\n");
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
