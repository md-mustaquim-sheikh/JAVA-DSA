
import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any fruits name :");
        String fruit = input.next();
// Enhanced switch case statement   
        switch (fruit) {
            case "apple" -> System.out.println("Red colour fruit");
            case "banana" -> System.out.println("yellow colour fruit");
            case "mango" -> System.out.println("green colour fruit");
            default -> System.out.println("Enter valid fruits name");
        }
    }
}
