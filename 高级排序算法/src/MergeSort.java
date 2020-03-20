  /*
 * 高级排序算法：归并排序 O(N*logN)
 * @auther：李博博
 *
 * */


public class MergeSort {
    // 实现方法：递归
    public static void sort(Comparable[] arr, int n) {
        mergerSort(arr, 0, n - 1);
    }

    // 递归地使左右两部分都排好序再进行融合
    private static void mergerSort(Comparable[] arr, int l, int r) {
        if (l >= r) { // 递归终止的条件
            return;
        }
        int mid = l + (r - l) / 2; // 防止溢出
        mergerSort(arr, l, mid);
        mergerSort(arr, mid + 1, r);
        merger(arr, l, mid, r);
    }

    private static void merger(Comparable[] arr, int l, int mid, int r) {
        Comparable[] newArr = new Comparable[r - l + 1]; // 用来暂存元素
        for (int i = l; i < arr.length; i++) {
            newArr[i - l] = arr[i];
        }
        int i = l;
        int j = mid + 1;  // 分别代表左右两个数组的初始位置
        for (int k = l; k <= r; k++) {
            if (i > mid) {      // 如果左半部分元素已经全部处理完毕
                arr[k] = newArr[j - l];
                j++;
            } else if (j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = newArr[i - l];
                i++;
            } else if (newArr[i - l].compareTo(newArr[j - l]) < 0) {
                arr[k] = newArr[i - l];
                i++;
            } else {
                arr[k] = newArr[j - l];
                j++;
            }
        }


    }
}
