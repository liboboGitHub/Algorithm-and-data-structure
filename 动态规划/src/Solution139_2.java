import java.util.HashSet;
import java.util.List;
import java.util.Set;


// 动态规划解法
class Solution139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> memo = new HashSet<>(wordDict);  // 直接可以初始化
        boolean[] ret = new boolean[s.length() + 1]; // 初始化为False
        ret[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (ret[j] && memo.contains(s.substring(j, i))) {
                    ret[i] = true;
                    break;
                }

            }

        }
        return ret[s.length()];

    }
}