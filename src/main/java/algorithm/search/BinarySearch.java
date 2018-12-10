package algorithm.search;

public class BinarySearch {

    public static int search(Comparable key, Comparable[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            Comparable midValue = array[mid];
            if (midValue.compareTo(key) > 0) {
                right = mid;
            } else if (midValue.compareTo(key) < 0) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursionSearch(Comparable key, Comparable[] array) {
        return compare(key, array, 0, array.length - 1);
    }

    private static int compare(Comparable key, Comparable[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        Comparable midValue = array[mid];
        if (midValue.compareTo(key) > 0) {
            return compare(key, array, left, mid);
        } else if (midValue.compareTo(key) < 0) {
            return compare(key, array, mid, right);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 8, 11, 23, 24, 43, 43, 52, 54, 71, 76, 87};
        System.out.println(search(8, array));
        System.out.println(recursionSearch(8, array));
    }
}
