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
        return recursionSearch(key, array, 0, array.length - 1);
    }

    private static int recursionSearch(int key, int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        int midValue = array[mid];
        if (midValue > key) {
            return recursionSearch(key, array, left, mid - 1);
        } else if (midValue < key) {
            return recursionSearch(key, array, mid + 1, right);
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
        int length = array.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue > key) {
                right = mid - 1;
            } else if (midValue < key) {
                left = mid + 1;
            } else {
                if ((mid + 1) != length && array[mid + 1] == key) {
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
        int length = array.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue <= key) {
                if ((mid + 1) != length && array[mid + 1] <= key) {
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

    /**
     * 从循环有序数组中找出给定值的下标
     * 循环有序数组等分为两部分，一部分是有序数组，一部分是循环有序数组
     * 如果是有序数组进行二分查找，如果是循环有序数组进行循环有序数组二分查询
     * @param key
     * @param array 如[4, 5, 6, 1, 2, 3]
     * @return
     */
    public static int searchInCycleArray(int key, int[] array) {
        return searchInCycleArray(key, array, 0, array.length - 1);
    }

    public static int searchInCycleArray(int key, int[] array, int left, int right) {
        while (left <= right) {
            int mid = (right + left) >> 1;
            int midValue = array[mid];
            if (midValue > key) {
                // 如果midValue > key需要看mid左侧的数组是否是有序数组
                if (midValue > array[left]) {
                    //如果是有序数组判断最小值是否小于等于给定值
                    if (array[left] <= key) {
                        return recursionSearch(key, array, left, mid - 1);
                    } else {
                        //如果有序数组部分最小值小于给定值，对循环的部分进行循环有序数组二分查询
                        return searchInCycleArray(key, array, mid + 1, right);
                    }
                } else {
                    //如果不是有序数组，直接对循环的部分进行循环有序数组二分查询
                    return searchInCycleArray(key, array, left, mid - 1);
                }
            } else if (midValue < key) {
                if (midValue < array[right]) {
                    if (array[right] >= key) {
                        return recursionSearch(key, array, mid + 1, right);
                    } else {
                        return searchInCycleArray(key, array, left, mid - 1);
                    }
                } else {
                    return searchInCycleArray(key, array, mid + 1, right);
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
