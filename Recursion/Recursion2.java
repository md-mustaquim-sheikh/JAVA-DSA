// package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion2 {
    public static void main(String[] args) {
        int n = 9;
        boolean[] arr = new boolean[n];
        for (int i = 1; i < arr.length; i = i + 2) {
            arr[i] = true;
        }
        boolean isFirst = true;
        while (n/2 > 0) {
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        arr[i] = false;
                        isFirst = true;
                    }
                }

            }
            isFirst = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        arr[i] = false;
                        isFirst = true;
                    }
                }

            }
            n /= 4;
        }
        System.out.println(Arrays.toString(arr));

    }

    // static int lastRemaining(int n) {
    // while (n > 1) {

    // }
    // }

    static int rotatedBS(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return rotatedBS(arr, target, start, mid - 1);
            } else {
                return rotatedBS(arr, target, mid + 1, end);
            }
        }
        if (target >= arr[mid] && target <= arr[end]) {
            return rotatedBS(arr, target, mid + 1, end);
        }
        return rotatedBS(arr, target, start, mid - 1);
    }

    static boolean issorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && issorted(arr, ++index);
    }

    static int linearsearch(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return linearsearch(arr, target, ++index);
    }

    static ArrayList<Integer> findallindex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findallindex(arr, target, ++index, list);
    }

    static ArrayList<Integer> findallindex2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansfrombelow = findallindex2(arr, target, ++index);
        list.addAll(ansfrombelow);
        return list;
    }
}
