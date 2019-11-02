/*
 * 高级排序算法：快速排序 O(N*logN)
 * 创建者：李博博
 *
 * */

public class QuickSort {

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);

    }

    private static void sort(Comparable[] arr, int l, int r) {
        // 优化1
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 对arr[l...r]部分进行partition(切分)操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l]; // 随机选择一个切分元素
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);

        return j;
    }

    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("QuickSort", arr);

        return;
    }

}
