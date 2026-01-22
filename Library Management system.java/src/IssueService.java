import java.sql.*;
import java.util.Scanner;
public class IssueService {
    public static void issueBook() {
        try (Connection conn = Database.getConnection()) {
//            System.out.print("Enter Book ID: ");
            int bookId = Integer.parseInt(InutHelper.readInt("Enter Book ID: "));
//            System.out.print("Enter Member ID: ");
            int memberId = Integer.parseInt(InutHelper.readInt("Enter Member ID: "));
            String q = "INSERT INTO issue_return (book_id, member_id, issue_date) VALUES (?, ?, CURDATE())";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, bookId);
            ps.setInt(2, memberId);
            ps.executeUpdate();
            System.out.println("Book Issued!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void returnBook() {
        try (Connection conn = Database.getConnection()) {

//            System.out.print("Enter Issue Transaction ID: ");
            int issueId = Integer.parseInt(InutHelper.readInt("Enter Issue Transcation ID: "));

            String q = "UPDATE issue_return SET return_date = CURDATE() WHERE id = ? AND return_date IS NULL";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, issueId);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Book Returned Successfully!");
            else System.out.println("Invalid Issue ID or Book Already Returned!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
