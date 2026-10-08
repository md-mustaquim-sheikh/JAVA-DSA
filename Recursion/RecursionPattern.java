// package Recursion;

public class RecursionPattern {
    public static void main(String[] args) {
        pattern(5,0);
    }

    static void pattern(int r, int c){
        if (r == 0) {
            return ;
        }
        if (c < r) {
            pattern(r, ++c);
            System.out.print("* ");
        } else {
            pattern(--r, 0);
            System.out.println();
        }
    
    }

    static void pattern1(int r, int c){
        if (r == 0) {
            return ;
        }
        if (c < r) {
            System.out.print("* ");
            pattern1(r, ++c);
        } else {
            System.out.println();
            pattern1(--r, 0);
        }
    
    }
}
