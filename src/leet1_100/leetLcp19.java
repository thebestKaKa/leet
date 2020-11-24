package leet1_100;

public class leetLcp19 {
    public static int minimumOperations(String leaves) {
        //注意审题 是替换不是交换
        //动态规划中等题 难点在寻找状态转移方程和边界确定
        int n = leaves.length();
        int[][] f = new int[n][3];
        int isred = 0;
        int isyellow = leaves.charAt(0) == 'y'?1:0;
        f[0][0] = isyellow;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for(int i = 1;i < n;i++){
            isred = leaves.charAt(i) == 'r'?1:0;
            isyellow = leaves.charAt(i) == 'y'?1:0;
            f[i][0] = f[i - 1][0] + isyellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isred;
            if(i >= 2)
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isyellow;
        }
        return f[n-1][2];
    }

    public static void main(String[] args) {
        String s = "ryryryryyry";
        System.out.println(minimumOperations(s));
    }
}
