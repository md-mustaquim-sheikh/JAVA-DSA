// package Searching;
import java.util.Arrays;

public class Binary2d {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 }
        };

        System.out.println(searchMatrix(arr, 9));
    }

    // https://leetcode.com/problems/search-a-2d-matrix/
    static boolean searchMatrix(int[][] matrix, int target) {
        int rStart = 0, rEnd = matrix.length - 1;
        int c = matrix[0].length - 1;

        while (rStart < rEnd) {
            int rMid = (rStart + rEnd) / 2;
            if (matrix[rMid][c] == target) {
                return true;
            }
            if (matrix[rMid][c] < target) {
                rStart = rMid + 1;
            } else {
                rEnd = rMid;
            }
        }
        return bs(matrix, target, rEnd);
    }
    static boolean bs(int[][] matrix, int target, int r){
        int cStart = 0;
        int cEnd = matrix[0].length - 1;

        while (cStart <= cEnd) {
            int cMid = (cStart + cEnd) / 2;
            if (matrix[r][cMid] == target) {
                return true;
            }
            if (matrix[r][cMid] < target) {
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }
        return false;
    }

    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    static int[] search(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[] { r, c };
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }

        }
        return new int[] { -1, -1 };

    }

    // Binary Search for Compltely Sorted 2D Array (Failed For Leetcode Due to Edge cases)
    static int[] search2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // if only 1 row is present
        if (rows == 1) {
            return binarySearch(matrix, target, rows - 1, 0, cols - 1);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) {
            int rMid = (rStart + rEnd) / 2;
            if (matrix[rMid][cMid] == target) {
                return new int[] { rMid, cMid };
            } else if (matrix[rMid][cMid] < target) {
                rStart = rMid;
            } else {
                rEnd = rMid;
            }
        }

        // now we have two rows
        // check whether the target is in the column of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[] { rStart + 1, cMid };
        }

        // search in 1st half
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, target, rStart, 0, cMid - 1);
        }
        // search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, target, rStart, cMid + 1, cols - 1);
        }
        // search in 3rd half & 4th half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, target, rStart + 1, 0, cMid - 1);
        } else {
            return binarySearch(matrix, target, rStart + 1, cMid + 1, cols - 1);
        }
    }

    static int[] binarySearch(int[][] matrix, int target, int rows, int cStart, int cEnd) {

        while (cStart <= cEnd) {
            int cMid = (cStart + cEnd) / 2;
            if (matrix[rows][cMid] == target) {
                return new int[] { rows, cMid };
            } else if (matrix[rows][cMid] < target) {
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}