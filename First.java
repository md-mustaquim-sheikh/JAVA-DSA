import java.util.Scanner;
import java.util.Arrays;

public class First {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        int j = arr.length;
       
       for (int i = 0; i < j ; i++){
            int temp = arr[i];
            arr[i] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
}