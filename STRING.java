import java.io.StringBufferInputStream;
import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class STRING {

    public static void main(String[] args) {
        String s = "(a)(b)(a)aaa";
        List<List<String>> knowledge = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of("a", "yes")),
                        new ArrayList<>(List.of("c", "two"))));
        // System.out.println(knowledge.get(0).get(1));
        System.out.println(evaluate(s, knowledge));

    }

    // https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
    static String evaluate(String s, List<List<String>> knowledge) {
        String original = s;
        int index = 0;
        while (index < original.length()) {
            String temp = "";
            if (original.charAt(index) == '(') {
                index++;
                while (original.charAt(index) != ')') {
                    temp += original.charAt(index);
                    index++;
                }
            }
            for (int i = 0; i < knowledge.size(); i++) {
                if (temp.equals(knowledge.get(i).get(0))) {
                    s = s.replace('(' + temp + ')', knowledge.get(i).get(1));
                }               
                if (i == knowledge.size() - 1 || knowledge.isEmpty()) {
                    s = s.replace('(' + temp + ')', "?");
                }
            }
            index++;
        }
        return s;
    }

    // https://leetcode.com/problems/text-justification/
    static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            String s = "";
            while (index < words.length && s.length() + words[index].length() <= maxWidth) {
                s += words[index] + " ";
                index++;
            }
            ans.add(s);
        }
        return ans;
    }

    // pno -
    static String reverseWords(String s) {
        String reverse = "";
        int end = s.length() - 1;

        while (end >= 0) {
            // Skip all spaces
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            int start = end;
            // Find the beginning of the word
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            reverse += s.substring(start + 1, end + 1);
            reverse += " ";
            // Move to the character before the word
            end = start - 1;
        }
        return reverse.trim();
    }

    // pno -
    static int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += ('z' - s.charAt(i) + 1) * (i + 1);
        }
        return ans;
    }

    // pno - 12
    // Input: num = 3749
    // Output: "MMMDCCXLIX"
    // static String intToRoman(int num) {

    // }

    // pno - 13
    // Input: s = "III"
    // Output: 3
    // optimized solution is in the leetcode
    static int romanToInt(String s) {
        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                ans += 1;
            }
            if (s.charAt(i) == 'V') {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    ans += 4;
                    i--;
                } else {
                    ans += 5;
                }
            }
            if (s.charAt(i) == 'X') {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    ans += 9;
                    i--;
                } else {
                    ans += 10;
                }
            }
            if (s.charAt(i) == 'L') {
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    ans += 40;
                    i--;
                } else {
                    ans += 50;
                }
            }
            if (s.charAt(i) == 'C') {
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    ans += 90;
                    i--;
                } else {
                    ans += 100;
                }
            }
            if (s.charAt(i) == 'D') {
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    ans += 400;
                    i--;
                } else {
                    ans += 500;
                }
            }
            if (s.charAt(i) == 'M') {
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    ans += 900;
                    i--;
                } else {
                    ans += 1000;
                }
            }
        }
        return ans;
    }

    // pno - 58
    // Input: s = "Hello World"
    // Output: 5
    static int lengthOfLastWord(String s) {

        // String[] str = s.split(" ");
        // return str[str.length - 1].length();

        s.stripTrailing();

        int end = s.length() - 1;

        // while (end >= 0 && s.charAt(end) == ' ') {
        // end--;
        // }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;

    }

    // pno - 6
    static void convert(String s, int numRows) {

        for (int i = 0; i < numRows; i++) {
            System.out.println(s.charAt(i));
        }

    }

    static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}