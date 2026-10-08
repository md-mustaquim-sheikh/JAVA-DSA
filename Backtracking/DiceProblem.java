// package Backtracking;

import java.util.ArrayList;


public class DiceProblem {
    public static void main(String[] args) {
        findcombination("", 4);
        // System.out.println(findcombinationreturn(new ArrayList<>(), 4));
    }

    static void findcombinationFace(String p, int target, int face){
        if (target == 0) {
            System.out.println(p);
            return ;
        }
        for (int i = 1; i <= face && i <= target; i++) {
            findcombinationFace( p + i, target - i, face);
        }
    }

    static void findcombination(String p, int target){
        if (target == 0) {
            System.out.println(p);
            return ;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            findcombination( p + i, target - i);
        }
    }

    static ArrayList<ArrayList<Integer>> findcombinationreturn(ArrayList<Integer> p, int target){
        if (target == 0) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(p)); // Copy of p
            return ans;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            p.add(i);                                               // Choose
            ans.addAll(findcombinationreturn(p, target - i));       // Explore
            p.remove(p.size() - 1);                                 // Remove
        }
        return ans;
    }
}
