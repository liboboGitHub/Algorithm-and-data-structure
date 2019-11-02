/*
 * 基础排序： 冒泡排序V1.0（冒泡排序往后走，插入排序往前走）
 * 创建者：李博博
 *
 * */

public class BubbleSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(Object[] nums, int i, int minIndex) {
        Object t = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = t;

    }

    // 测试BubbleSort
    public static void main(String[] args) {

        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("BubbleSort", arr);

        return;
    }

}
