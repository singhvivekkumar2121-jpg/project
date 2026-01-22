import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean loggedIn = false;
        while (!loggedIn) loggedIn = AuthService.login();
        try  {
            while (true) {
                System.out.println("\n=== LIBRARY MENU ===");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Register Member");
                System.out.println("4. Issue Book");
                System.out.println("5. Return Book");
                System.out.println("6. Search Book");
                System.out.println("7. Logout & Exit");
                System.out.print("Choose: ");
//                int choice = sc.nextInt();
                int choice = Integer.parseInt(InutHelper.readInt("Enter your Choice"));

//                sc.nextLine();


                switch (choice) {
                    case 1 -> BookService.addBook();
                    case 2 -> BookService.viewBooks();
                    case 3 -> MemberService.addMember();
                    case 4 -> IssueService.issueBook();
                    case 5 -> IssueService.returnBook();
                    case 6 -> BookService.searchBook();
                    case 7 -> { System.out.println("Logged out. Bye!"); System.exit(0); }
                    default -> System.out.println("Invalid Choice!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
