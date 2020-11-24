package leet1_100;

public class leet53 {
    //子数组最大和
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
