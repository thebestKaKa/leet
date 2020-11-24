package leet1_100;

public class leet28 {
    public static int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        for (int i = 0; i < hl - nl + 1; i++) {
            if (haystack.substring(i, i + nl).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(strStr("hello","ll"));
    }
}
