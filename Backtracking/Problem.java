// package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCE";
        System.out.println();
    }

    // https://leetcode.com/problems/word-search/
    static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] check = new boolean[rows][cols];

        // Try every cell as a starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && existBacktrack(board, check, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean existBacktrack(char[][] board, boolean[][] check, String word, int r, int c, int index) {
        if (index == word.length() - 1) {
            return true;
        }

        // Boundary check and visited/mismatch check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if (check[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        check[r][c] = true;

        // Explore all 4 directions (Down, Right, Left, Up)
        boolean found = existBacktrack(board, check, word, r + 1, c, index + 1) ||
                existBacktrack(board, check, word, r, c + 1, index + 1) ||
                existBacktrack(board, check, word, r, c - 1, index + 1) ||
                existBacktrack(board, check, word, r - 1, c, index + 1);

        // Backtrack: Unmark the cell so it's available for other paths
        check[r][c] = false;

        return found;
    }

    // https://leetcode.com/problems/combination-sum-iii//
    static List<List<Integer>> combinationSum3(int k, int n, ArrayList<Integer> pList, int start) {
        if (n == 0 && pList.size() == k) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(pList));
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 0) {
            return ans;
        }
        for (int i = start; i <= 9; i++) {
            pList.add(i);
            ans.addAll(combinationSum3(k, n - i, pList, i + 1));
            pList.remove(pList.size() - 1);
        }
        return ans;
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target, ArrayList<Integer> pList, int start) {
        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(pList));
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (target < 0) {
            return ans;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            pList.add(candidates[i]);
            ans.addAll(combinationSum2(candidates, target - candidates[i], pList, i + 1));
            pList.remove(pList.size() - 1);
        }
        return ans;
    }

    // https://leetcode.com/problems/combination-sum/
    static List<List<Integer>> combinationSum(int[] candidates, int target, ArrayList<Integer> pList, int start) {
        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(pList));
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (target < 0) {
            return ans;
        }
        for (int i = start; i < candidates.length; i++) {
            pList.add(candidates[i]);
            ans.addAll(combinationSum(candidates, target - candidates[i], pList, i));
            pList.remove(pList.size() - 1);
        }
        return ans;
    }
}
