
/*
 * 基础排序辅助类：生成随机数组，检查是否有序，测试性能等等
 * 创建者：李博博
 * 创建时间：2019.8.11
 * */

import java.lang.reflect.Method;

public class SortTestHelper {
    public SortTestHelper() {

    }

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        //断言结果为true，则继续往下执行
        assert rangeL <= rangeL;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        return;
    }

    // 测试数组是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo((arr[i + 1])) > 0) {
                return false;
            }
        }
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
