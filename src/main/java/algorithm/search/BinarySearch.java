package algorithm.search;

/**
 * 二分查找
 */
@SuppressWarnings("Duplicates")
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
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue > key) {
                right = mid + 1;
            } else if (midValue < key) {
                left = mid - 1;
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
        int mid = (left + right) >> 1;
        int midValue = array[mid];
        if (midValue > key) {
            return compare(key, array, left, mid - 1);
        } else if (midValue < key) {
            return compare(key, array, mid + 1, right);
        } else {
            return mid;
        }
    }

    /**
     * 查找第一个值等于给定值的元素下标
     *
     * @param key
     * @param array
     * @return
     */
    public static int searchFirstIndex(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue > key) {
                right = mid - 1;
            } else if (midValue < key) {
                left = mid + 1;
            } else {
                if (mid != 0 && array[mid - 1] == key) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素下标
     *
     * @param key
     * @param array
     * @return
     */
    public static int searchLastIndex(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue > key) {
                right = mid - 1;
            } else if (midValue < key) {
                left = mid + 1;
            } else {
                if ((mid + 1) != array.length && array[mid + 1] == key) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素下标
     *
     * @param key
     * @param array
     * @return
     */
    public static int searchFirstGreaterThanEqualIndex(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue >= key) {
                if (mid != 0 && array[mid - 1] >= key) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素下标
     *
     * @param key
     * @param array
     * @return
     */
    public static int searchLastLessThanEqualIndex(int key, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue <= key) {
                if ((mid + 1) != array.length && array[mid + 1] <= key) {
                    left = mid - 1;
                } else {
                    return mid;
                }
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }
}
