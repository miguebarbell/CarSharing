import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    /**
     * Returns the sorted array of absolute numbers in ascending order.
     *
     * @param numbers the input array of String integer numbers
     * @return the sorted array of integer absolute numbers
     */
    public static int[] sortedAbsNumbers(String[] numbers) {
        // write your code here
        int[] response = new int[numbers.length];
        System.out.println("Arrays.stream(numbers).map(Integer::parseInt).map(num -> Math.abs(num)).sorted() = " + Arrays.stream(numbers).map(Integer::parseInt).map(num -> Math.abs(num)).sorted().toArray());
        System.out.println("numbers = " + numbers);
        return response;
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(sortedAbsNumbers(scanner.nextLine().split("\\s+")))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
