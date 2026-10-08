import java.lang.Math;

public class FabanacciNumber {
    public static void main(String[] args) {
        

    System.out.print(fiboformula(10));

    }
    
    static int fiboformula(int n){

        return (int)((Math.pow(((1 + Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
    }

    static int fibonacci(int n){
        if (n < 2) {
            return n;
        }

        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    // int a = 0, b = 1;
    // int c=0;
    // while (c<=n) {    
    //     System.out.print(c + " ");
    //     a = b;
    //     b = c;
    //     c = a + b;    
    // }
}