// package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        letterCombinations("23", "");
        System.out.println(letterCombinationsReturn("23", ""));
    }

    static void letterCombinations(String digits, String p) {
        if (digits.isEmpty()) {
            System.out.println(p);
            return;
        }
        String[] arr = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int digit = digits.charAt(0) - '0';
        int len = arr[digit - 2].length();
        for (int i = 0; i < len; i++) {
            char ch = arr[digit - 2].charAt(i);
            letterCombinations(digits.substring(1), p + ch);
        }

    }

    static ArrayList<String> letterCombinationsReturn(String digits, String p) {
        if (digits.isEmpty()) {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add(p);
            return ans;
        }
        String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int digit = digits.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < arr[digit].length(); i++) {
            char ch = arr[digit].charAt(i);
            ans.addAll(letterCombinationsReturn(digits.substring(1), p + ch));
        }
        return ans;
    }

    static List<List<Integer>> subset4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> inter = new ArrayList<>(outer.get(j));
                inter.add(nums[i]);
                outer.add(inter);
            }
        }
        return outer;
    }

    // https://leetcode.com/problems/is-subsequence/description
    static List<List<Integer>> subset3(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inter = new ArrayList<>(outer.get(i));
                inter.add(num);
                outer.add(inter);
            }
        }
        return outer;
    }

    static ArrayList<String> subset2(String s, String p) {
        if (s.isEmpty()) {
            ArrayList<String> ans = new ArrayList<String>();
            if (p.isEmpty()) {
                return ans;
            }
            ans.add(p);
            return ans;
        }
        ArrayList<String> left = subset2(s.substring(1), p + s.charAt(0)); // Take it
        ArrayList<String> right = subset2(s.substring(1), p); // Ignore it

        left.addAll(right);
        return left;
    }

    static void subset(String s, String p) {
        if (s.isEmpty()) {
            System.out.println(p);
            return;
        }
        subset(s.substring(1), p + s.charAt(0)); // Take it
        subset(s.substring(1), p); // Ignore it
    }

    static String skipaChar(String s, char skip) {
        if (s.isEmpty()) {
            return "";
        }
        return s.charAt(0) == skip ? skipaChar(s.substring(1), skip) : s.charAt(0) + skipaChar(s.substring(1), skip);
    }

    static String skipaString(String s, String skip) {
        if (s.isEmpty()) {
            return "";
        }
        return s.startsWith(skip) ? skipaString(s.substring(skip.length()), skip)
                : s.charAt(0) + skipaString(s.substring(1), skip);
    }
}
