
// package Sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { -1,-2,-3,0,4,32,12};
        bsRecursion(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }

    static void bsRecursion(int[] arr, int i, int j) {
        if (i == arr.length) {
            return;
        }
        if (j < arr.length - i) {
            if (arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
            bsRecursion(arr, i, ++j);
        }
        bsRecursion(arr, ++i, 1);
    }

    static void sort(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

}