
public class Wrapper {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 20;
        swap(a, b);

        Integer num1 = 10;
        Integer num2 = 20;
        swap(num1, num2);
        
        System.out.println(num1 + " " + num2);
    }

    static void swap(int a, int b){         // not sawap bcoz it's a pass by value not reference
        int temp = a;
        a = b;
        b = a;
    }

    static void swap(Integer a, Integer b){     // not swap bcoz of the final keyword in Integer Class
        Integer temp = a;
        a = b;
        b = a;
    }
    
}
