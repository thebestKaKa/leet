package leet1_100;

public class leet75 {
    public void sortColors(int[] nums) {
        //排序
        for (int i = 0; i < nums.length;i++){
            for (int j = i + 1; j < nums.length;j++){
                if (nums[i] >= nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void sortColors_2(int[] nums) {
        //重写数组
        int countRed = 0,countBlue = 0,countWhite = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0)countRed++;
            else if(nums[i] == 1)countBlue++;
            else countWhite++;
        }
        for(int i = 0;i < countRed; i++){
            nums[i] = 0;
        }
        for(int i = countRed;i < countRed + countBlue; i++){
            nums[i] = 1;
        }
        for(int i = countRed + countBlue;i < nums.length; i++){
            nums[i] = 2;
        }
    }

    public void sortColors_3(int[] nums) {
        //双指针法
        int p0 = 0,p1 = 0,temp = 0;
        for (int i = 0; i < nums.length;i++){
            if (nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1){
                    //这种情况为前端已经插入1
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }else if(nums[i] == 1){
                temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
    }

    public static void sortColors_4(int[] nums) {
        int p0 = 0,p2 = nums.length - 1,temp = 0;
        for (int i = 0;i <= p2;i++){
            while (i <= p2 && nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors_4(a);
        System.out.println(a);
    }
}
