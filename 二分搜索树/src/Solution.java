// 明确：是公共前缀，是公共前缀，是公共前缀，不属实公共字符串，

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(temp) != 0) {
                temp = temp.substring(0, temp.length() - 1); // substring不包含结尾索引的元素，每次减少最后一个元素
                if (temp.isEmpty()) {
                    return "";
                }
            }
        }
        return temp;

    }
}