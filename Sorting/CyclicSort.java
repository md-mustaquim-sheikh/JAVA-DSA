package Sorting;
import java.util.Arrays;
import java.util.List;

class CyclicSort{
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4};
        // sort(arr);
        System.out.println(firstMissingPositive(arr));

        
    }
    // pno - 448
    // Input: nums = [4,3,2,7,8,2,3,1]
    // Output: [5,6]
    static int[] findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1 ;
            if (arr[i] != arr[correct] ) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        int j = 0;
        int[] ans = new int[2];
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                ans[0] = arr[index];
                ans[1] = index + 1;
            }   
        }
        return ans; 
    }
    static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1 ;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct])  {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
             
        }
        return arr.length  + 1;
    }

    // pno - 268
    // Input: nums = [9,6,4,2,3,5,7,0,1]
    // Output: 8
    static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] ;
            if (arr[i] < arr.length && arr[i] != arr[correct])  {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
             
        }
        return arr.length;
    }

    static void sort(int[] arr){
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1 ;
            if (arr[i] != arr[correct] ) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }
}