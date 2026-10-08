public class Overloading {
    public static void main(String[] args) {
        // System.out.println(sum(1, 2));
        // System.out.println(sum(1, 2, 3));

        String a = new String("1020");
        String b = new String("1020");

        // String a = "1020";
        // String b = "1020";
        
        System.out.println(a.equals(b));
    }
    
    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    static void fun(int a) {
        System.out.println(a);
    }

    static void fun(String a) {
        System.out.println(a);
    }
}
