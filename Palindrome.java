public class Palindrome {
    public static void main(String[] args) {

        String str = "a";
        // System.out.println(isPalindrome("b"));
        System.out.println(longestPalindrome("ae"));

    }

    // pno - 5
    static String longestPalindrome(String s) {
        int maxlp = 0;
        int start = 0, end = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            int lp = 0;
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lp = j - i + 1;
                    boolean Palindrome = isPalindrome(s.substring(i, j + 1));
                    if (Palindrome == true && lp > maxlp) {
                        maxlp = lp;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        if (maxlp > 0) {
            return s.substring(start, end);
        }
        return String.valueOf(s.charAt(0));
        
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            int first = i;
            int last = s.length() - 1 - i;
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome1(int x) {
        if (x <= 0) {
            return false;
        }
        int original = x;
        int reverse = 0;
        while (x > 0) {
            int rem = x % 10;
            x /= 10;
            reverse = reverse * 10 + rem;
        }
        if (original != reverse) {
            return false;
        }
        return true;
    }
}
