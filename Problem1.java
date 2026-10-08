import java.util.ArrayList;
import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        int[] arr = { 1,2,4,2,1 };

        System.out.println(Arrays.toString(findEvenNumbers(arr)));
        System.out.println(Arrays.toString(findEvenNumbers2(arr)));

    }

    // pno - 2094
    static int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] digit = new int[10];
        for (int num : digits) {
            digit[num]++;
        }
        for (int last = 0; last < 9; last += 2) {
            if (digit[last] == 0) {
                continue;
            }
            digit[last]--;

            for (int first = 1; first <= 9; first++) {
                if (digit[first] == 0) {
                    continue;
                }
                digit[first]--;

                for (int mid = 0; mid <= 9; mid++) {
                    if (digit[mid] > 0) {
                        int temp = first * 100 + mid * 10 + last;
                        ans.add(temp);
                    }
                }
                digit[first]++;
            }
            digit[last]++;
        }
        return ans.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    static int[] findEvenNumbers2(int[] digits) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] digit = new int[10];
        for (int num : digits) {
            digit[num]++;
        }

        for (int i = 100; i < 999; i += 2) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;
            if (digit[a] != 0) {
                digit[a]--;
                if (digit[b] != 0) {
                    digit[b]--;
                    if (digit[c] != 0) {
                        ans.add(i);
                    }
                    digit[b]++;
                }
                digit[a]++;
            }
            
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static int sum(int[][] arr) {
        int max = Integer.MAX_VALUE;
        for (int[] arr1 : arr) {
            int ans = 0;
            for (int j = 0; j < arr1.length; j++) {
                ans = ans + arr1[j];
            }
            if (max < ans) {
                max = ans;
            }
        }
        return max;
    }
}
