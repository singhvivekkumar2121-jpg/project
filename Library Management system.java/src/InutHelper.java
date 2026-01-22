import java.util.Scanner;

public class InutHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readInt(String prompt){
        while(true){
            System.out.println(prompt);
            try{
                return scanner.nextLine();
            }
            catch (NumberFormatException e){
                System.out.println("Invalild input");
            }
        }
    }
}
