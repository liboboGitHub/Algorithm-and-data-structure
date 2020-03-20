import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int left = 0; // 左边窗口
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}