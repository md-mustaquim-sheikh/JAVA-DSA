public class Shadowing {
    static int x = 90; // This line will be shadowed at line 6

    public static void main(String[] args) {
        System.out.println(x);

        int x = 40;
        System.out.println(x);
        Scoping();

    }

    static void Scoping() {
        int x = 50;
        int y = 10;
        {
            // int x = 30; // This line will give an error because 'x' is already defined in the outer scope
            int a = 20;
        }
        // System.out.println(a); // This line will give an error because 'a' is not visible here
        System.out.println(x);
    }
}
