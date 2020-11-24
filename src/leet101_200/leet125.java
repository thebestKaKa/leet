package leet101_200;

public class leet125 {
    //判断回文串
    public boolean isPalindrome(String s) {
        StringBuffer t = new StringBuffer();
        for (int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                t.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer t_rev = new StringBuffer(t).reverse();
        return t.toString().equals(t_rev.toString());
    }

    public static void main(String[] args) {
        StringBuffer t = new StringBuffer();
        t.append('a');
        t.append('b');
        t.append('3');
        StringBuffer a = t;
        StringBuffer b = t.reverse();

        int w = 12;
        int e = 1;
        int i = 12^1;
        System.out.println(i);

    }
}
