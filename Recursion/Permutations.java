// package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1,1,2 };
        boolean[] check = new boolean[nums.length];
        System.out.println(permutationBacktrack(nums, new ArrayList<>(), check));
    }

    static int permutationCount(String s, String p) {
        if (s.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = s.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count += (permutationCount(s.substring(1), first + ch + second));
        }
        return count;
    }
    
    // https://leetcode.com/problems/permutations-ii/
    static void permutationBacktrack(int[] nums, ArrayList<Integer> list, List<List<Integer>> ans, boolean[] check) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // Skip the Duplicates element for the next recursion level
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !check[i - 1]) {
                continue;
            }
            if (!check[i]) {
                check[i] = true;
                list.add(nums[i]);
                permutationBacktrack(nums, list, ans, check);
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
    }

    // https://leetcode.com/problems/permutations/
    static List<List<Integer>> permutationBacktrack(int[] nums, ArrayList<Integer> list, boolean[] check) {
        if (list.size() == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(list));
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(nums[i]);
                ans.addAll(permutationBacktrack(nums, list, check));
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
        return ans;
    }

    // https://leetcode.com/problems/permutations/
    static ArrayList<ArrayList<Integer>> permutation(int[] nums, ArrayList<Integer> temp) {
        if (nums.length == 0) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(temp);
            return ans;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int num = nums[0];

        for (int i = 0; i <= temp.size(); i++) {

            ArrayList<Integer> first = new ArrayList<>(temp.subList(0, i));
            ArrayList<Integer> second = new ArrayList<>(temp.subList(i, temp.size()));

            first.add(num);
            first.addAll(second);

            ans.addAll(permutation(Arrays.copyOfRange(nums, 1, nums.length), first));
        }

        return ans;
    }

    static ArrayList<String> permutation1(String s, String p) {
        if (s.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = s.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutation1(s.substring(1), first + ch + second));
        }
        return ans;
    }

    static void permutation(String s, String p) {
        if (s.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = s.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutation(s.substring(1), first + ch + second);
        }
    }
}
