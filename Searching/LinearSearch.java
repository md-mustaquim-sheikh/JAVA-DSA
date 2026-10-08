package Searching;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 23, 12, 45, 65, 78, 97, 62, 92, 102, 1 };
        String name = "Mustaquim";
        int[][] arr2D = {
                { 2, 3, 4 },
                { 3, 45, 6, 89 },
                { 12, 34, 102 }
        };

        System.out.println("Element found at index :" + LinearSearch(arr, 62));
        System.out.println("Element is :" + arr[LinearSearch(arr, 62)]);

        System.out.println("Char is found - " + LinearSearch1(name, 'q'));

        System.out.println("Search in range (2,5)");
        System.out.println("Element Found at index: " + LinearSearch2(arr, 92, 2, 5));

        System.out.println("MAX value of the array: " + MaxValues(arr));
        System.out.println("MIN value of the array: " + MinValues(arr));

        System.out.println("Element found at index :" + Arrays.toString(LinearSearch2D(arr2D, 62)));

        System.out.println("MAX value of the 2D array: " + MaxValues2D(arr2D));
        // System.out.println("MIN value of the 2D array: " + MinValues2D(arr2D));
    }

    static int LinearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static boolean LinearSearch1(String name, char target) {
        if (name.length() == 0) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (target == name.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    // Linear Serach in Range
    static int LinearSearch2(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Max Value in the array
    static int MaxValues(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // Min Value in the array
    static int MinValues(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    // Linear Search in 2D array
    static int[] LinearSearch2D(int[][] arr, int target) {
        if (arr.length == 0) {
            return new int[] { -1, -1 };
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // MAX value in 2D array
    static int MaxValues2D(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}