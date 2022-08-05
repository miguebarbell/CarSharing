import java.util.Comparator;
import java.util.List;

class Utils {
    static class UtilsComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
    public static void sortStrings(List<String> strings) {
        strings.sort(new UtilsComparator());

    }
}
