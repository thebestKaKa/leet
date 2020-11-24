package leet1_100;

public class leet88 {
    //合并两个有序数组(可以尝试双指针用num1从后往前判断大小)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j;
        for(j = 0; j < n; j++){
            while (nums2[j] >= nums1[i] && i < m){
                i++;
            }
            for(int z = m;z > i; z--){
                nums1[z] = nums1[z - 1];
            }
            nums1[i] = nums2[j];
            m = m + 1;
        }
    }
}
