package algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 常规二分查找
     *
     * @param key
     * @param array
     * @return
     */
    public static int search(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int midValue = array[mid];
            if (midValue > key) {
                right = mid;
            } else if (midValue < key) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 常规二分查找 递归版
     *
     * @param key
     * @param array
     * @return
     */
    public static int recursionSearch(int key, int[] array) {
        return compare(key, array, 0, array.length - 1);
    }

    private static int compare(int key, int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = array[mid];
        if (midValue > key) {
            return compare(key, array, left, mid);
        } else if (midValue < key) {
            return compare(key, array, mid, right);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 8, 11, 23, 24, 43, 43, 52, 54, 71, 76, 87};
        System.out.println(search(8, array));
        System.out.println(recursionSearch(8, array));
    }
}
