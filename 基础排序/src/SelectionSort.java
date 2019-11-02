/*
 * 基础排序一：选择排序 (注意和冒泡排序的区别和理解,冒泡排序的交换在内循环里面)
 * 特点：支持泛型（没有泛型数组）
 * 创建者：李博博
 *
 * */

public class SelectionSort {
    public static void sort(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j].compareTo(nums[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(Object[] nums, int i, int minIndex) {
        Object t = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = t;

    }

    // 测试
    public static void main(String[] args) {

//        // 测试Integer
//        Integer[] test = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        SelectionSort.selectionSort(test);
//        for (int i = 0; i < test.length; i++) {
//            System.out.print(test[i] + " ");
//        }
//        System.out.println();
//
//        // 测试Double
//        Double[] b = {4.4, 3.3, 2.2, 1.1};
//        SelectionSort.selectionSort(b);
//        for (int i = 0; i < b.length; i++) {
//            System.out.print(b[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试String
//        String[] c = {"D", "C", "B", "A"};
//        SelectionSort.selectionSort(c);
//        for (int i = 0; i < c.length; i++) {
//            System.out.print(c[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试自定义的类 Student
//        Student[] d = new Student[4];
//        d[0] = new Student("D", 90);
//        d[1] = new Student("C", 100);
//        d[2] = new Student("B", 95);
//        d[3] = new Student("A", 95);
//        SelectionSort.selectionSort(d);
//        for (int i = 0; i < d.length; i++)
//            System.out.println(d[i]);
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort(arr);
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("SelectionSort", arr);

        return;
    }

}
