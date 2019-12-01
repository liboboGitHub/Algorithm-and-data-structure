public class Fibonacci3 {

    /*
     * 使用动态规划思想的特点：
     * 1. 相当于记忆化搜索的逆过程
     * 2. 自底向上
     * 3. 解释
     *    英文版：Split the original question into several sub-questions, and save the answers to the sub-questions,
     *    so that each sub-question is solved only once, and the answer to the original question is finally obtained (from Wikipedia)
     *    翻译：将原问题拆解成若干的子问题，同时保存子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案（来自维基百科）
     * */
    private int Fibonacci(int n) {
        // 辅助数组
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        Fibonacci3 fibonacci3 = new Fibonacci3();
        long startTime = System.currentTimeMillis();        // 获取当前时间
        System.out.println("计算出的值是：" + fibonacci3.Fibonacci(40));    // 测试的程序
        long endTime = System.currentTimeMillis();          // 程序结束的时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
