package leet1_100;

public class leet69 {
    public static int mySqrt(int x) {
        double t = Math.sqrt(x);
        return (int)t;
    }
    public static int mySqrt_plus(int x) {
        int low = 0,high = x,mid,ans = 0;
        while(low <= high){
            mid = (low + high)/2;
            if ((long)mid * mid <= x){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        double a =1.11;
        int b = (int)a;
        System.out.print(mySqrt_plus(2147395599));
    }
}
