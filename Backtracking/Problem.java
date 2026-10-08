// package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int[] num = { 10, 1, 2, 7, 6, 1, 5 };
        Arrays.sort(num);
        int max = Math.min(0, 0);
        // System.out.println(combinationSum3(3, 7, new ArrayList<>(), 1));
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
