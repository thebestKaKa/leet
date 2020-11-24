package leet1_100;

public class leet26 {
    public static int removeDuplicates(int[] nums) {
    //删除排序数组中的重复项
        int p = 0;
        for(int i = 1; i < nums.length; i++){
            while (nums[p] == nums[i]){
                i++;
                if (i >= nums.length) {
                    break;
                }
            }
            if(i<nums.length){
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }
    public static void main(String[] args) {
        int[] b = {1,1,2,2,3,3,3,4,5,5,6,7,7};
        int a = removeDuplicates(b);
        System.out.print(a);
    }
}
