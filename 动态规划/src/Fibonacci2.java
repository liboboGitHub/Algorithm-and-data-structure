public class Fibonacci2 {

    /*
     * 记忆化搜索优化递归问题的特点：
     * 1. 每个斐波那契相应的数值只计算一次
     * 2. 自顶向下
     *
     * */
    private int Fibonacci(int n, int[] m) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (m[n] == -1) {
            m[n] = Fibonacci(n - 1, m) + Fibonacci(n - 2, m);
            return m[n];
        }
        return m[n];

    }

    public static void main(String[] args) {
        // 初始化记忆性数组的值
        int n = 40;
        int[] memory = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memory[i] = -1;
        }
        Fibonacci2 fibonacci2 = new Fibonacci2();
        long startTime = System.currentTimeMillis();        // 获取当前时间
        System.out.println("计算出的值是：" + fibonacci2.Fibonacci(n, memory));    // 测试的程序
        long endTime = System.currentTimeMillis();          // 程序结束的时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
