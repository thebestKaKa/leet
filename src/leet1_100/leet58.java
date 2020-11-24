package leet1_100;

public class leet58 {
    //最后一个单词长度
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end<0) return 0;
        int start = end;
        while(start>=0&&s.charAt(start)!=' ')start--;
        return end - start;
    }

}
