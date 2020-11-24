package leet1_100;

public class leet67 {
    //二进制求和
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int carry = 0;
        for (int i = 0, j = 0; i < a.length() || j < b.length(); i++, j++) {
            int ai, bj;
            ai = i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            bj = j < b.length() ? (b.charAt(b.length() - 1 - j) - '0') : 0;
            ans.append((ai + bj + carry) % 2);
            carry = (ai + bj + carry) / 2;
        }
        if(carry == 1){
            ans.append("1");
        }
        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String a = addBinary("1111","11");
        System.out.print(a);
    }
}
