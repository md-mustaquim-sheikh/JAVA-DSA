public class VarArgs {
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5));
        System.out.println(sum(10, 20, "30", "40", "50"));
        System.out.println(sum("Hello", " ", "World", "!"));
        System.out.println(sum(1.5f, 2.5f, 3.5f));
    }

    static int sum(int... arr) {
        int result = 0;
        for (int a : arr) {
            result += a;
        }
        return result;
    }

    static int sum(int a, int b, String... arr) {
        int result = a + b;
        for (String s : arr) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    static String sum(String... arr) {
        String result = "";
        for (String a : arr) {
            result += a;
        }
        return result;
    }

    static float sum(float... arr) {
        float result = 0;
        for (float a : arr) {
            result += a;
        }
        return result;
    }
}
