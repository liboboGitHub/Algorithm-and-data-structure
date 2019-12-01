public class Fibonacci1 {

    // 将以斐波那契数列为例来逐渐展开动态规划思想的学习
    // 版本1：普通递归写法
    private int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);

    }

    public static void main(String[] args) {
        Fibonacci1 fibonacci1 = new Fibonacci1();
        long startTime = System.currentTimeMillis();        // 获取当前时间
        System.out.println("计算出的值是：" + fibonacci1.Fibonacci(40));    // 测试的程序
        long endTime = System.currentTimeMillis();          // 程序结束的时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
