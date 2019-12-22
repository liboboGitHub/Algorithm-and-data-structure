class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        // 双指针法
        int index = 0;      // 子字符串的索引
        int i = 0;          // 原字符串的的索引
        while (index < s.length() && t.indexOf(s.charAt(index), i) >= i) { // 如果找不到其中任何一个字符的话，查找失败
            i = t.indexOf(s.charAt(index), i) + 1;
            index++;
        }
        return index == s.length();

    }
} 