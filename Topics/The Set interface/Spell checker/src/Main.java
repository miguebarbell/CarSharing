import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> wordsToCheck = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine().toLowerCase();
            wordsToCheck.add(s);
        }
        int m = Integer.parseInt(in.nextLine());
        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = in.nextLine().toLowerCase();
            dictionary.addAll(Arrays.asList(s.split(" ")));
        }
        dictionary.removeAll(wordsToCheck);
        dictionary.forEach(System.out::println);
    }
}
