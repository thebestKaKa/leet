package leet1_100;

public class leet38 {
    //外观数列
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder ans = new StringBuilder();
        String str = countAndSay(n - 1);
        int length = str.length();
        int start = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                ans.append(i - start).append(str.toCharArray()[start]);
            } else if (str.toCharArray()[i] != str.toCharArray()[start]) {
                ans.append(i - start).append(str.toCharArray()[start]);
                start = i;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }
}
