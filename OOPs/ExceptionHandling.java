public class ExceptionHandling {
    public static void main(String[] args) throws MyException {
        int a = 5, b = 0;
        String name = "kunal";
        try {
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Exception resolved");
        }
        // System.out.println(divide(a, b));

        if (name.equals("kunal")) {
            throw new MyException("name is found");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by Zero");
        }
        return a/b;
    }
}

class MyException extends Exception {
    public MyException(String message){
        super(message);
    }
}
