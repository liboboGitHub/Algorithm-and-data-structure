class Solution343 {

    // 解法一：使用记忆化搜素的回溯算法
//    public int integerBreak(int n) {
//
//        int[] memory = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            memory[i] = -1;
//        }
//
//        return breakInteger(n, memory);
//    }
//
//    private int breakInteger(int n, int[] memory) {
//        if (n == 1) {
//            return 1;
//        }
//        if (memory[n] != -1) {
//            return memory[n];
//        }
//        int ret = -1;
//        for (int i = 1; i < n; i++) {
//            ret = Math.max(ret, (Math.max(i * (n - i), i * breakInteger(n - i, memory))));
//        }
//        memory[n] = ret;
//        return ret;
//    }

    // 解法2：动态规划(想的不是很明白)
    public int integerBreak(int n) {
        int[] memory = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memory[i] = -1;
        }

        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memory[i] = Math.max(memory[i], (Math.max(j * (i - j), j * memory[i - j])));

            }

        }
        return memory[n];

    }
}