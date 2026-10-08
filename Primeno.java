import java.util.Scanner;
public class Primeno {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        for (int i = 1; i <= 99; i++){
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        //  Check if the number is prime

        // boolean isPrime = true;
        // for (int i = 2; i*i <= num; i++) {
        //     if (num % i == 0) {
        //         isPrime = false;
        //         break;
        //     }
        // }

        // if (isPrime) {
        //     System.out.println(num + " is a prime number.");
        // } else {
        //     System.out.println(num + " is not a prime number.");
        // } 
    }

    // prime number check using method/function
    static boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        int i = 2;
        while (i*i <= num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return i*i > num;  }
}