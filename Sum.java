
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        int num1, num2;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number :");
        num1 = in.nextInt();
        System.out.print("Enter second number :");
        num2 = in.nextInt();
        int ans = sum(num1, num2);
        System.out.println(ans);
    }

    static int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

}
