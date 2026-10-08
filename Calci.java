import java.util.Scanner;
public class Calci{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        
        int ans=0;
        OUTER:
        while (true) {
            System.out.print("Enter a operator :");
            char op = input.next().trim().charAt(0);
            switch (op) {
                case '+', '-', '*', '/' -> {
                    System.out.print("Enter two number :");
                    int num1=input.nextInt();
                    int num2=input.nextInt();
                    switch (op) {
                        case '+' -> ans = num1 + num2;
                        case '-' -> ans = num1 - num2;
                        case '*' -> ans = num1 * num2;
                        case '/' -> ans = num1 / num2;
                    }
                System.out.println(ans);
                }
                case 'x', 'X' -> {
                    break OUTER;
                }
                default -> System.out.println("invslid operstor");
            }
        }
    }
}
