import java.util.Arrays;

class Solution455 {

    // 数组的转置
    private void resverse(int[] primary) {
        int[] ret = new int[primary.length];
        for (int i = 0; i < primary.length; i++) {
            ret[i] = primary[primary.length - 1 - i];
        }
        for (int i = 0; i < primary.length; i++) {
            primary[i] = ret[i];
        }
        return;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        resverse(g);
        Arrays.sort(s);
        resverse(s);
        int gi = 0, si = 0;
        int res = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                res++;
                gi++;
                si++;
            } else {
                gi++;
            }
        }
        return res;
    }


}