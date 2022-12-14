import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    /**
     * Returns the largest absolute value in the array of numbers.
     *
     * @param numbers the input array of String integer numbers
     * @return the maximum integer absolute value in the array
     */
    public static int maxAbsValue(String[] numbers) {
        // write your code here
        Optional<Integer> response =
            Arrays.stream(numbers).map(num -> Integer.parseInt(num)).map(Math::abs).max(Integer::compare);
//        System.out.println("response = " + response);
        return response.get();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(maxAbsValue(scanner.nextLine().split("\\s+")));
    }
}
