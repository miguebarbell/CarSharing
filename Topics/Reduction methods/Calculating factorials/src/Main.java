import java.util.Arrays;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.*;

class Main {

    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        // write your code here
        // create array with elements
        if (n == 0) {
            return 1;
        }
        if (n == 1){
            return 1;
        }
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("arr[i] = " + arr[i]);
//        }


        OptionalLong response = Arrays.stream(arr).reduce((sum, num) -> sum * num);
//        System.out.println("response = " + response.getAsLong());
        return response.getAsLong();
//        System.out.println("arr = " + arr);
//        return arr[0];

    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(factorial(n));
    }
}
