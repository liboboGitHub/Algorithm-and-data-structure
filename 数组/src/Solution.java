class Solution {
    public int myAtoi(String str) {
        if (str.equals("-") || str.trim().equals("")) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-' || chars[i] >= '0' && chars[i] <= '9' || chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                stringBuilder.append(chars[i]);
            }
        }

        String ret = String.valueOf(stringBuilder);
        if (ret.length() == 0) {
            return 0;
        }
        if ((ret.charAt(0) <= '0' || ret.charAt(0) > '9') && ret.charAt(0) != '-') {
            return 0;
        }
        // 处理负数
        StringBuilder stringBuilder1 = new StringBuilder();
        if (ret.charAt(0) == '-') {
            for (int i = 1; i < ret.length(); i++) {
                if (ret.charAt(i) >= '0' && ret.charAt(i) <= '9') {
                    stringBuilder1.append(ret.charAt(i));
                } else {
                    break;
                }
            }
            String Number = String.valueOf(stringBuilder1);
            long num = Long.parseLong(Number) - Long.parseLong(Number) * 2;
            if (num < -2147483648) {
                return -2147483648;
            } else {
                return (int) num;
            }

        } else {
            for (int i = 0; i < ret.length(); i++) {
                if (ret.charAt(i) >= '0' && ret.charAt(i) <= '9') {
                    stringBuilder1.append(ret.charAt(i));
                } else {
                    break;
                }
            }
            String Number = String.valueOf(stringBuilder1);
            long num1 = Long.parseLong(Number);
            if (num1 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) num1;
        }


    }

//    public static void main(String[] args) {
//        String s = "words and 987";
//        System.out.println(myAtoi(s));
//    }
}