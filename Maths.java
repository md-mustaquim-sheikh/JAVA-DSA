import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Maths {
    public static void main(String[] args) {

        // System.out.println(commonFactors(6, 12));
        System.out.println(fizzBuzz(3));
    }
    static int numberOfSteps(int num) {
        
    }

    // pno - 412
    // Input: n = 15
    // Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
    static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(i + "");
            }
        }
        return ans;
    }

    // pno - 231
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;

        // while (n % 2 == 0) {
        // n /= 2;
        // }
        // return n==1;
    }

    // pno - 
    static int commonFactors(int a, int b) {
        int commonfactors = 0;
        int n = a > b ? a : b;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (a % i == 0 && b % i == 0) {
                commonfactors ++;
            }
        }
        return commonfactors;
    }

    static ArrayList<Integer> factor(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    ans.add(i);
                } else {
                    ans.add(i);
                    ans.add(n / i);
                }
            }

        }
        return ans;
    }

    static String primes(int n) {
        boolean[] primes = new boolean[n + 1];

        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j < primes.length; j += i) {
                    primes[j] = true;
                }

            }

        }
        StringBuilder ans = new StringBuilder();
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                ans.append(i + " ");
            }
        }
        return ans.toString();
    }

    // pno - 67
    // Input: a = "1010", b = "1011"
    // Output: "10101"
    static String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (m >= 0 || n >= 0) {
            int sum = carry;
            if (m >= 0) {
                sum += (a.charAt(m) - '0');
                m--;
            }
            if (n >= 0) {
                sum += (b.charAt(n) - '0');
                n--;
            }
            ans.append(sum % 2);
            carry = sum / 2;

        }
        if (carry == 1) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }

    // pno - 832
    // Input: image = [[1,1,0],[1,0,1],[0,0,0]]
    // Output: [[1,0,0],[0,1,0],[1,1,1]]
    static int[][] flipAndInvertImage(int[][] image) {

        for (int[] row : image) {
            for (int col = 0; col < image.length / 2; col++) {
                int temp = row[col];
                row[col] = row[image.length - col - 1];
                row[image.length - col - 1] = temp;
            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                image[i][j] ^= 1;
            }
        }
        return image;
    }

    static int xorOfno(int a) {
        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1) {
            return 1;
        }
        if (a % 4 == 2) {
            return a + 1;
        }
        return 0;
    }

    static int noOfsetBits(int n) {
        int setbits = 0;
        while (n > 0) {
            n = (n & (n - 1));
            setbits++;

            // if ((n & 1) == 1) {
            // setbits++;
            // }
            // n = n >> 1;
        }
        return setbits;
    }

    static double pow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return ans;
    }

    static int digitsinbaseB(int n, int b) {

        return (int) (Math.log(n) / Math.log(b)) + 1;

    }

    static int magicno(int n) {

        int base = 5;
        int ans = 0;

        while (n > 0) {
            int last = (n & 1); // this will give last index in binary
            n = n >> 1; // Right shift one digit at a time
            ans += last * base; // for n = 3, 0*5^1 + 1*5^2 + 1*5^3;
            base *= 5; // base 5^1 - 5^2 - 5^3 ---- so on
        }
        return ans;

    }

    static int isUniqueinOdd(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique = n; // (n ^ n) = 0 , order doesnot matter
        }
        return unique % 3;
    }

    static int isUniqueinEven(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n; // (n ^ n) = 0 , order doesnot matter
        }
        return unique;
    }

    static boolean isEven(int n) {
        return (n & 1) == 0; // (n & 1) -> give the last digit of binary no.
    }

    // pno - 189
    static void rotate(int[] nums, int k) {
        while (k > nums.length) {
            k -= nums.length;
        }

        if (k < nums.length) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    static void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // pno - 3622
    // Input: n = 99
    // Output: true
    static boolean checkDivisibility(int n) {
        int sum = 0, product = 1, total = 0, originalNum = n;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        total = sum + product;
        if (originalNum % total == 0) {
            return true;
        }
        return false;
    }

    // armstrong number check
    static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem * rem * rem;
            num /= 10;
        }
        return sum == originalNum;
    }

    // reverse the number
    /*
     * int ans = 0;
     * while (num>0) {
     * int rem = num%10;
     * num /= 10;
     * ans = ans*10 + rem;
     * }
     * System.out.println(ans);
     */

    // Count no of digits in a number
    /*
     * System.out.print("Enter a number:");
     * int num = scanner.nextInt();
     * System.out.print("Enter a digit to count:");
     * int digit = scanner.nextInt();
     * 
     * int count = 0;
     * while (num>0){
     * int rem = num%10;
     * num /= 10;
     * if (rem==digit){
     * count++;
     * }
     * }
     * System.out.println("Count of digit is: "+count);
     */

    // Largest of three numbers
    /*
     * System.out.print("Enter first number: ");
     * int num1 = scanner.nextInt();
     * System.out.print("Enter second number: ");
     * int num2 = scanner.nextInt();
     * System.out.print("Enter third number:");
     * int num3 = scanner.nextInt();
     * 
     * if (num1>num2 && num1>num3){
     * System.out.println(num1+ " is greater");
     * } else if (num2>num1 && num2>num3) {
     * System.out.println(num2+ " is greater");
     * } else {
     * System.out.println(num3+ " is greater");
     * }
     */
}
