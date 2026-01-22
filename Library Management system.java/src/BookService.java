import java.sql.*;
import java.util.Scanner;
public class BookService {
    public static void addBook() {
        try (Connection conn = Database.getConnection()) {
//            System.out.print("Enter Book Title: ");
            String title = InutHelper.readInt("Enter Book Title");

//            System.out.print("Enter Author: ");
            String author = InutHelper.readInt("Enter Author");

//            System.out.print("Enter Quantity: ");
            int qty =Integer.parseInt(InutHelper.readInt("Enter Quantity"));

            String query = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, qty);
            ps.executeUpdate();
            System.out.println("Book Added Successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void viewBooks() {
        try (Connection conn = Database.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");
            System.out.println("\n--- Book List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | Qty: " +
                        rs.getInt("quantity"));
            }
            System.out.println("-----------------\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void searchBook() {
        try (Connection conn = Database.getConnection()) {

//            System.out.print("Enter Book Title Keyword: ");
            String keyword = InutHelper.readInt("Enter Book Title Keyword");

            String q = "SELECT * FROM books WHERE title LIKE ?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- Search Results ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | Qty: " +
                        rs.getInt("quantity"));
            }
            if (!found) System.out.println("No Books Found!");
            System.out.println("----------------------\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
