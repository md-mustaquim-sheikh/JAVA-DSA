// package Recursion;
public class Recursion {
    public static void main(String[] args) {
        
    }

    // 50. Pow(x, n)
    // Input: x = 2.00000, n = 10
    // Output: 1024.00000
    static double myPow(double x, int n) {
        double ans = 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        for (long i = 1; i <= n ; i++) {
            ans *= x;
        }
        return ans;
    }

    static void print(int n) {
        if (n == 6) {
            return;
        }
        System.out.println(n);
        print(n + 1);
    }

    static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    static boolean pallindrome(String a, int start, int end){
        // while (start < end) {                        // no recursion code
        //     if (a.charAt(start) != a.charAt(end)) {
        //         return false;
        //     }
        //     start++;
        //     end--;
        // }
        // return true;

        if (start >= end) {
            return true;
        }
        if (a.charAt(start) == a.charAt(end)) {
            return pallindrome(a, ++start, --end);
        } 
        return false;
    }

    static int binarysearch(int[] arr, int target, int start, int end){
        
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
           return binarysearch(arr, target, start, mid - 1);
        }           
        return binarysearch(arr, target, mid + 1, end);       
    }
}
