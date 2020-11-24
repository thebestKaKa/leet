package leet1_100;

public class leet35 {
    //搜索插入位置
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                continue;
            } else {
                return i;
            }
        }
        return nums.length;
    }
}
