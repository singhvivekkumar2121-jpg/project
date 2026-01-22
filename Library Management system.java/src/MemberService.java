import java.sql.*;
import java.util.Scanner;
public class MemberService {
    public static void addMember() {
        try (Connection conn = Database.getConnection()) {
//            System.out.print("Enter Member Name: ");
            String name = InutHelper.readInt("{Enter Member Name");

//            System.out.print("Enter Phone: ");
            String phone = InutHelper.readInt("Enter Phone: ");

            String q = "INSERT INTO members (name, phone) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.executeUpdate();
            System.out.println("Member Registered!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
