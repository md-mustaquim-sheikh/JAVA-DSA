// package Sorting;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,5,6,4 };
        ssRecursion(arr,arr.length ,1,0);
        System.out.println(Arrays.toString(arr));
    }

    static void ssRecursion(int[] arr, int i, int j, int max){
        if (i == 0) {
            return;
        }
        if (i > j) {
            if (arr[max] < arr[j]) {
                ssRecursion(arr, i, j + 1, j);
            } else {
                ssRecursion(arr, i, j + 1, max);
            }
        } else {
            int temp = arr[i - 1];
            arr[i - 1] = arr[max];
            arr[max] = temp;
            ssRecursion(arr, --i, 1, 0);
        }
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = 0;

            // finding max value in subarray
            for (int j = 1; j <= last; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }

            // swapiing the values
            int temp = arr[last];
            arr[last] = arr[max];
            arr[max] = temp;
        }
    }
}
