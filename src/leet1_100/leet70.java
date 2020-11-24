package leet1_100;

public class leet70 {
    public static int climbStairs(int n) {
        if(n == 0 || n == 1)return 1;
        int ans = climbStairs(n-1) + climbStairs(n-2);
        return ans;
    }

    public static int climbStairs_plus(int n) {
        if(n == 0 || n == 1)return 1;
        int p = 0,q = 1,r = 1;
        for(int i = 1;i < n;i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.print(climbStairs(3));
    }
}
