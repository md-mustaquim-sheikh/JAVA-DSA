import java.util.ArrayList;

public class LambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums.add(i + 1);
        }
        System.out.println(nums);
        nums.forEach((num) -> System.out.println(num * 2));

        LambdaFunction calculator = new LambdaFunction();
        System.out.println(calculator.operate(5, 3, calculator.sum));
    }

    Operation sum = (a, b) -> a + b;
    Operation sub = (a, b) -> a - b;
    Operation prod = (a, b) -> a * b;

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}
