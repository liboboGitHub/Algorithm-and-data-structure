import java.util.ArrayList;
import java.util.List;

class Solution17 {
    private String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    private ArrayList<String> ret;  // 装结果

    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        if (digits.equals("")) {
            return ret;
        }
        findCombination(digits, 0, "");
        return ret;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {   // 递归结束的条件
            ret.add(s);
            return;
        }

        Character c = digits.charAt(index);
        assert c.compareTo('0') >= 0 && c.compareTo('9') <= 0 && c.compareTo('1') != 0;
        String res = letterMap[c - '0'];
        for (int i = 0; i < res.length(); i++) {
            findCombination(digits, index + 1, s + res.charAt(i));  // 关键
        }
        return;

    }
}