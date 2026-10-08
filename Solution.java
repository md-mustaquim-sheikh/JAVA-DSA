import java.util.Arrays;
import java.lang.Math;

class Solution {

    public static void main(String[] args) {
        int[] nums1 = { 0, 0, 0 };
        int m = 0, n = 1;

        int[] nums2 = { 5,4,3 };

        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // pno - 66
    // Input: digits = [1,2,3] ( + 1 )
    // Output: [1,2,4]
    static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // If we reach here, all digits were 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    // pno - 26
    // Input: nums = [0,0,1,1,1,2,2,3,3,4]
    // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    // pno - 28
    // Input: haystack = "sadbutsad", needle = "sad"
    // Output: 0
    // Explanation: "sad" occurs at index 0 and 6. so return 0
    static int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    // pno - 14 Longest Common Prefix
    // Input: strs = ["flower","flow","flight"]
    // Output: "fl"
    static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(ans)) {
                ans = ans.substring(0, ans.length() - 1);
            }

            if (ans.isEmpty())
                return "";
        }

        return ans;
    }

    // Problem no - 1295
    static int findNumbers(int[] nums) {
        int even = 0;
        for (int i : nums) {
            int digit = (int) (java.lang.Math.log10(i)) + 1;
            if (digit % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    // problem no - 1672
    // Input: accounts = [[1,5],[7,3],[3,5]]
    // Output: 10
    static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            // max = Math.max(max, sum);
            return max;
        }
        return -1;
    }

    // pn- 1
    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }

        }
        return new int[] { -1, -1 };
    }

    // pn - 11
    // Input: height = [1,8,6,2,5,4,8,3,7]
    // Output: 49
    static int maxArea(int[] height) {
        int first = 0, last = height.length - 1;
        int maxwater = 0;
        while (first < last) {
            int water = (last - first) * (Math.min(height[first], height[last]));
            maxwater = Math.max(maxwater, water);
            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }
        return maxwater;
    }

}