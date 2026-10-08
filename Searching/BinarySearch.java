// package Searching;

import java.util.*;
import java.lang.*;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 2, 2, 1, 2, 2 };

        System.out.println(searchPivotwithDuplicate(nums));
        System.out.println(findMin(nums));

    }

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
               end--;
            }
        }
        return nums[start];

        // int start = 0;
        // int end = nums.length - 1;
        // while (start < end) {
        //     int mid = (start + end) / 2;
        //     if (nums[mid] < nums[end]) {
        //         end = mid;
        //     } else {
        //         start = mid + 1;
        //     }
        // }
        // return nums[start];
    }

    // pno - 69
    static double mySqrt(int x) {
        int start = 1, end = x / 2;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < 3; i++) { // here, precison upto 3 digit
            while (root * root <= x) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }

    static double newtonSqrt(int n) {
        double x = n;
        double root;

        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 1) { // here, precison < 1
                break;
            }
            x = root;
        }
        return root;
    }

    // pno - 35
    // nums = [1,3,5,6], target = 2
    // Output: 1
    static int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        return index;
    }

    // pno - 33
    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4
    static int search(int[] nums, int target) {
        int pivot = searchPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length);
    }

    static int searchPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int searchPivotwithDuplicate(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (end > mid && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (start < mid && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[mid] > arr[start] || arr[mid] == arr[start] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // pno - 1095
    // Input: mountainArr = [1,2,3,4,5,3,1], target = 3
    // Output: 2
    static int findInMountainArray(int target, int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int ans1 = binarySearch2(arr, target, 0, end, true);
        if (ans1 == -1) {
            int ans2 = binarySearch2(arr, target, start, arr.length - 1, false);
            return ans2;
        }
        return ans1;
    }

    // pno- 852
    // Input: arr = [0,1,2,3,5,6,4,3,2]
    // Output: 1
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // pno - 34
    // Input: nums = [5,7,7,8,8,10], target = 8
    // Output: [3,4]
    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        return ans;

    }

    static int search(int[] arr, int target, boolean isfirstOccur) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (isfirstOccur) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // pno - 744
    // Input: letters = ["c","f","j"], target = "a"
    // Output: "c"
    static char ceiling(char[] arr, char target) {
        int start = 0, end = arr.length - 1;
        // if (target>arr[arr.length-1]) {
        // return arr[0];
        // }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[start % arr.length];
    }

    // floor of a number
    // floor = greatest element in the array smaller or equal to target
    static int floor(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // Ascending Order Binary Search
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    // Descending Order Binary Search
    static int binarySearch1(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Order Agnostic Binary Search
    static int binarySearch2(int[] arr, int target, int start, int end, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
