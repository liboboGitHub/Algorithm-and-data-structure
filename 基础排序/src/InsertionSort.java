/*
 * 基础排序一： 插入排序（往前交换）
 * 特点：支持泛型（没有泛型数组）
 * 创建者：李博博
 *
 * */
public class InsertionSort {

//    public static void sort(Comparable[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }
//    }

     // 改进后的插入排序
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            Comparable e = arr[i];
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Object[] nums, int i, int minIndex) {
        Object t = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = t;

    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("InsertionSort", arr);

        return;
    }


}
