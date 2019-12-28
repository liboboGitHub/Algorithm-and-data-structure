import java.util.HashSet;
import java.util.List;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return ret(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);

    }

    private boolean ret(String s, HashSet<String> strings, int startindex, Boolean[] memo) {
        if (startindex == s.length()) {
            return true;
        }
        if (memo[startindex] != null) {
            return memo[startindex];
        }
        for (int endindex = startindex + 1; endindex <= s.length(); endindex++) {
            if (strings.contains(s.substring(startindex, endindex)) && ret(s, strings, endindex, memo)) {
                memo[startindex] = true;
                return memo[startindex];
            }

        }

        memo[startindex] = false;
        return memo[startindex];
    }
}

// 附加
/*
 * boolean是基本数据类型
 * Boolean是它的封装类，和其他类一样，有属性有方法，可以new，例如：
 * Boolean flag = new Boolean("true");  boolean 则不可以！
 * Boolean 是 boolean 的实例化对象类，和 Integer对应 int 一样
 * 自jdk1.5.0以上版本后，Boolean在"赋值"和判断上和boolean一样，
 * 即是你： boolean b1 = true ; 或者 Boolean b2 = true ; 都可以。
 * 唯一只能使用Boolean上的就是从列表或者哈希表获取值时。
 * 比如 boolean t = false;
 * Map map = new HashMap();
 * map.put("t", t);
 * 那么获取值时只能用
 * Boolean t1 = (Boolean) map.get(t); //前面只能用Boolean强制转换，不能使用boolean.
 */