import java.util.Scanner;
public class Swap{
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter first number :");
    int num1 = in.nextInt();
    System.out.println("Enter second number :");
    int num2 = in.nextInt();
    swap(num1,num2);
    }
    public static void swap(int b,int a) {
    System.out.println(a);
    System.out.println(b);
    }
}