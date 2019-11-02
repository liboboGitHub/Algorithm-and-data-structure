/*
 * 基础排序一： 冒泡排序 V2.0
 * 特点：支持泛型（没有泛型数组）
 * 创建者：李博博
 *
 * */
public class BubbleSort2 {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int newn; // 使用newn进行优化

        do {

            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;

        } while (newn > 0);

    }

    private static void swap(Object[] nums, int i, int minIndex) {
        Object t = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = t;

    }

    // 测试BubbleSort
    public static void main(String[] args) {

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("BubbleSort2", arr);

        return;
    }

}
