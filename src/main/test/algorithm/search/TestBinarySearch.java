package algorithm.search;

import org.junit.jupiter.api.Test;

public class TestBinarySearch {

    private int[] sortedArray = {1, 2, 3, 4, 5, 6, 8, 11, 23, 24, 43, 43, 52, 54, 71, 76, 87};

    private int[] duplicateSortedArray = {1, 2, 3, 4, 5, 6, 8, 8, 8, 8, 11, 23, 24, 43, 43, 52, 54, 71, 76, 87};

    @Test
    public void testCommonBinarySearch() {
        System.out.println(BinarySearch.search(8, sortedArray));
    }

    @Test
    public void testRecursionSearch() {
        System.out.println(BinarySearch.recursionSearch(8, sortedArray));
    }

    @Test
    public void testSearchFirstIndex() {
        System.out.println(BinarySearch.searchFirstIndex(8, sortedArray));
        System.out.println(BinarySearch.searchFirstIndex(8, duplicateSortedArray));
        System.out.println(BinarySearch.searchFirstIndex(1, sortedArray));
    }

    @Test
    public void testSearchLastIndex() {
        System.out.println(BinarySearch.searchLastIndex(8, sortedArray));
        System.out.println(BinarySearch.searchLastIndex(8, duplicateSortedArray));
        System.out.println(BinarySearch.searchLastIndex(87, sortedArray));
    }

    @Test
    public void testSearchFirstGreaterThanEqualIndex() {
        System.out.println(BinarySearch.searchFirstGreaterThanEqualIndex(8, sortedArray));
        System.out.println(BinarySearch.searchFirstGreaterThanEqualIndex(8, duplicateSortedArray));
        System.out.println(BinarySearch.searchFirstGreaterThanEqualIndex(9, duplicateSortedArray));
    }

    @Test
    public void testSearchLastLessThanEqualIndex() {
        System.out.println(BinarySearch.searchLastLessThanEqualIndex(8, sortedArray));
        System.out.println(BinarySearch.searchLastLessThanEqualIndex(8, duplicateSortedArray));
        System.out.println(BinarySearch.searchLastLessThanEqualIndex(9, duplicateSortedArray));
    }
}
