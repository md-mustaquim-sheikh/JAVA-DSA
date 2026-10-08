public class Exception {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int c = a / b; // This will cause an ArithmeticException
            System.out.println("Result: " + c);
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("This is a custom message from the Exception class.");
    }
        
}
