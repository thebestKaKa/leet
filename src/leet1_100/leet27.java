package leet1_100;

public class leet27 {
    //移除元素
    public static int removeElement(int[] nums, int val) {
        int i = 0,j = nums.length - 1;
        int count = 0;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else {
                if (nums[j] == val) {
                    count++;
                    j--;
                } else {
                    nums[i] = nums[j];
                    count++;
                    i++;
                    j--;
                }
            }
        }
        return nums.length-count;
    }



    public static void main(String[] args) {
        int[] z = {0,1,2,2,2,2,4,2};
        int a = removeElement(z,2);
        System.out.print(a);
    }
}
