// package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion1 {
    public static void main(String[] args) {
        String a = "abc";

    }

    static int count0(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            count++;
        }
        return count0(n / 10, count);
    }

    static int reverse(int n, int len) {
        // int len = (int)(Math.log10(n) + 1);
        // make helper function -> helper(int n, int len)
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * (int) (Math.pow(10, len - 1)) + reverse(n / 10, len - 1);
    }

    static boolean pallindromeNo(int n) {
        return n == reverse(n, (int) (Math.log10(n) + 1));
    }

    static int sumofdigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumofdigits(n / 10);
    }

    static int productofdigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        return n % 10 * productofdigits(n / 10);
    }

    static void nto1(int n) {
        // if return type is void
        if (n == 0) {
            return;
        }
        System.out.println(n);
        nto1(n - 1);

        // if return type is int
        // if (n == 1) {
        // return 1;
        // }
        // System.out.println(n);
        // return nto1(n-1);
    }

    static void onetoN(int n) {
        // if return type is void
        if (n == 0) {
            return;
        }
        onetoN(n - 1);
        System.out.println(n);

    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int sumofN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumofN(n - 1);
    }

}
