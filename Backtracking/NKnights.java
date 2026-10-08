// package Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(nKnights(board, 0, 0, n));
    }

    static int nKnights(boolean[][] board, int row, int col, int n) {
        if (n == 0) {
            // display(board);
            // System.out.println();
            return 1;
        }
        int count = 0;
        if (row == board.length) {
            return 0;
        }
        if (col == board.length) {
            return nKnights(board, row + 1, 0, n);
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += nKnights(board, row, col + 1, n - 1);
            board[row][col] = false;
        }
        count += nKnights(board, row, col + 1, n);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check above left
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }

        // Check above right
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }

        // Check right above
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }

        // Check left above
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }

        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
