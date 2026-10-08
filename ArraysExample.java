import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.lang.reflect.Array;

public class ArraysExample {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2,4,1 };
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        System.out.println(ans);
    }

    // https://leetcode.com/problems/next-permutation/
    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Find pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Find successor and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Reverse suffix
        reverse(nums, i + 1, nums.length - 1);
    }

    // pno - 1477
    // static int minSumOfLengths(int[] arr, int target) {
    // }

    // pno - 189
    static void rotate(int[] nums, int k) {
        int i = 0;
        int j = nums.length - k;
        while (k > 0) {
            int temp = nums[i];
            nums[i] = nums[nums.length - k];
            nums[nums.length - k] = temp;
            i++;
            k--;
        }
        reverse(nums, i, nums.length - 1);

        // while (k > nums.length) {
        // k -= nums.length;
        // }

        // if (k < nums.length) {
        // reverse(nums, 0, nums.length - 1);
        // reverse(nums, 0, k - 1);
        // reverse(nums, k, nums.length - 1);
        // }
    }

    static void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // pno - 1752
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    // pno - 3483
    // Input: digits = [1,2,3,4]
    // Output: 12
    static int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;
        // Last digit must be even
        for (int last = 0; last <= 8; last += 2) {
            if (freq[last] == 0) {
                continue;
            }
            freq[last]--; // Use one occurrence of the last digit

            // First digit: cannot be 0
            for (int first = 1; first <= 9; first++) {
                if (freq[first] == 0) {
                    continue;
                }
                freq[first]--; // Use one occurrence of the first digit

                // Middle digit can be any remaining digit
                for (int middle = 0; middle <= 9; middle++) {
                    if (freq[middle] > 0) {
                        count++;
                    }
                }
                // Put first digit back
                freq[first]++;
            }
            // Put last digit back
            freq[last]++;
        }
        return count;
    }

    // 2091. Removing Minimum and Maximum From Array
    // Input: nums = [2,10,7,5,4,1,8,6]
    // Output: 5
    static int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxindex = 0, minindex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxindex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minindex = i;
            }
        }
        int first = 0, last = 0;
        if (maxindex < minindex) {
            first = maxindex + 1;
            last = minindex + 1;
        } else {
            first = minindex + 1;
            last = maxindex + 1;
        }
        int delete = Math.min(nums.length - first + 1, last);
        return Math.min(delete, (first + (nums.length - last + 1)));
    }

    // // 1D array
    // int[] arr = new int[5];
    // // taking input using for loop
    // for (int i = 0; i < 5; i++) {
    // arr[i] = in.nextInt();
    // }

    // // output using for each loop
    // for (int num : arr) {
    // System.out.print(num + " ");
    // }

    // // 2D array
    // int[][] arr2 = new int[3][5];
    // // Taking input from user
    // for (int row = 0; row < arr2.length; row++) {
    // for (int col = 0; col < arr2[row].length; col++) {
    // arr2[row][col] = in.nextInt();
    // }
    // }
    // // Output using for each loop
    // for (int[] a : arr2) {
    // System.out.println(Arrays.toString(a));
    // }

    // Swap(arr, 0, 1);
    // System.out.println(Arrays.toString(arr));

    // System.out.println(Max(arr));

    // Swapping values in an array
    // static void Swap(int[] arr, int index1, int index2) {
    // int temp = arr[index1];
    // arr[index1] = arr[index2];
    // arr[index2] = temp;
    // }

    // Maximum element in an array
    // static int Max(int[] arr) {
    // int max = arr[0];
    // for (int i = 1; i < arr.length; i++) {
    // if (max < arr[i]) {
    // max = arr[i];
    // }
    // }
    // return max;
    // }

    // Reverse of an array
    static void Reverse(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
    }
}
