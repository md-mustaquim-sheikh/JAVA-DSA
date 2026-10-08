// package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-23,-5,23,-90,-45,30,9,6,2,1};
        System.out.println(Arrays.toString(mergesort(arr)));
        mergesortInplace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesortInplace(int[] arr, int s, int e) {
        if ((e - s) == 1) {
            return;
        }
        int mid = (s + e) / 2;
        mergesortInplace(arr, s, mid);
        mergesortInplace(arr, mid, e);

        mergeInplace(arr, s, mid, e);
    }
    static void mergeInplace(int[] arr, int s, int m, int e) {
        int[] ans = new int[e - s];
        int index = 0;
        int i = s, j = m;
        while (i < m || j < e) {
            if (i == m) {
                ans[index] = arr[j];
                j++;
                index++;
                continue;
            }
            if (j == e) {
                ans[index] = arr[i];
                i++;
                index++;
                continue;
            }
            if (arr[i] < arr[j]) {
                ans[index++] = arr[i];
                i++;
            } else {
                ans[index++] = arr[j];
                j++;
            }
        }
        for (int k = 0; k < ans.length; k++) {
            arr[s+k] = ans[k];
        }
    }

    static int[] mergesort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        // int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(mergesort(Arrays.copyOfRange(arr, 0, mid)), mergesort(Arrays.copyOfRange(arr, mid, arr.length)));
    }
    static int[] merge(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < arr1.length || j < arr2.length) {
            // if arr1 element is completed and arr2 element is left
            if (i == arr1.length) {
                ans[index] = arr2[j];
                j++;
                index++;
                continue;
            }
            // if arr2 element is completed and arr1 element is left
            if (j == arr2.length) {
                ans[index] = arr1[i];
                i++;
                index++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                ans[index++] = arr1[i];
                i++;
            } else {
                ans[index++] = arr2[j];
                j++;
            }
        }
        return ans;
    }
}
