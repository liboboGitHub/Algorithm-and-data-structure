/*
 * 基础排序： 希尔排序（基于插入排序）
 * 创建者：李博博
 * 参考： https://blog.csdn.net/qq_39207948/article/details/80006224
 * */
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int N = arr.length;

        // 分组（刚开始的增量整个数组一半）
        for (int gap = N / 2; gap > 0; gap = gap / 2) {

            // 对各个分组进行插入排序

            for (int i = gap; i < N; i++) {
                insertSort(arr, gap, i);
            }
        }
    }

    private static void insertSort(Comparable[] arr, int gap, int i) {
        Object inserted = arr[i];

        int j = 0;
        for (j = i - gap; j >= 0; j = j - gap) { //每次只执行一次
            arr[j + gap] = arr[j];
        }
        arr[j + gap] = (Comparable) inserted;

    }


}
