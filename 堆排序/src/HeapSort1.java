public class HeapSort1 {
    // 对整个arr数组使用HeapSort1排序
    // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);

        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort1", arr);
        return;
    }
}
