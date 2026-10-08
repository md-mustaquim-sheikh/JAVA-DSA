// package Backtracking;

import java.util.Arrays;

public class SudokoSolver {
    public static void main(String[] args) {
        int[][] validBoard = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        }; // Output: true
        int[][] invalidBoard = {
                { 8, 3, 0, 0, 7, 0, 0, 0, 8 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        }; // Output: false
        System.out.println(sudoku(validBoard));
        

    }
    // https://leetcode.com/problems/valid-sudoku/
    static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int r = -1, c = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    r = i;
                    c = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) { // if found some empty element in row -> break
                break;
            }
        }
        if (emptyLeft) {
            return true; // Sudoko is Solved
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafeValid(board, r, c, num)) {
                board[r][c] = (char)(num + '0');
                if (isValidSudoku(board)) {
                    return true; // Sudoku is solved
                } else {
                    board[r][c] = '.'; // Backtrack
                }
            }
        }
        return false;
    }
    private static boolean isSafeValid(char[][] board, int row, int col, int num) {
        char ch = (char) (num + '0');

        // check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }

        // check the col
        for (char[] nums : board) {
            if (nums[col] == ch) {
                return false;
            }
        }

        // check the 3 X 3 matrix
        int sqrt = (int) Math.sqrt(board.length);
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;
        for (int i = rStart; i < rStart + sqrt; i++) {
            for (int j = cStart; j < cStart + sqrt; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean sudoku(int[][] board) {
        int n = board.length;
        int r = -1, c = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) { // if found some empty element in row -> break
                break;
            }
        }
        if (emptyLeft) {
            for (int i = 0; i < board.length; i++) {
                System.err.println(Arrays.toString(board[i]));

            }
            return true; // Sudoko is Solved
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, r, c, num)) {
                board[r][c] = num;
                if (sudoku(board)) {
                    return true;            // Sudoku is solved
                } else {
                    board[r][c] = 0;        // Backtrack
                }
            }
        }
        return false; // Sudoku cannot be solved
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // check the col
        for (int[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }

        // check the 3 X 3 matrix
        int sqrt = (int) Math.sqrt(board.length);
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;
        for (int i = rStart; i < rStart + sqrt; i++) {
            for (int j = cStart; j < cStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
