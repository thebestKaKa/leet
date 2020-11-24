package leet101_200;

public class leet167 {
    // 二数之和
    public int[] twoSum(int[] numbers, int target) {
        //暴力法
        int a1 = 0, a2 = 1;
        int[] ans ={a1, a2};
        for(int i = 0; i < numbers.length;i++){
            for (int j = i + 1;j < numbers.length;j++){
                if (numbers[i] + numbers[j] == target){
                    a1 = i + 1;
                    a2 = j + 1;
                    break;
                }
            }
        }
        ans[0] = a1;
        ans[1] = a2;
        return ans;
    }
    public int[] twoSum_2(int[] numbers, int target) {
        //缩小检查范围 双指针法
        int a1 = 0, a2 = numbers.length - 1;
        int[] ans ={a1, a2};
        while ((numbers[a1] + numbers[a2]) != target){
            if (numbers[a1] + numbers[a2] < target)a1++;
            else a2--;
        }
        ans[0] = a1 + 1;
        ans[1] = a2 + 1;
        return ans;
    }

    public int[] twoSum_3(int[] numbers, int target) {
        //二分法
        int a1 = 0,a2 = 0;
        for (int i = 0; i < numbers.length; i++){
            int low = i + 1;
            int high = numbers.length - 1;
            int mid = (low + high)/2;
            while (low <= high){
                if(numbers[i] + numbers[mid] > target){
                    high = mid - 1;
                }else if (numbers[i] + numbers[mid] < target){
                    low = mid + 1;
                }else {
                    break;
                }
                mid = (low + high)/2;
            }
            if (numbers[i] + numbers[mid] == target){
                a1 = i + 1;
                a2 = mid + 1;
                break;
            }
        }
        int[] ans = {a1,a2};
        return ans;
    }

    public int[] twoSum_3_plus(int[] numbers, int target) {
        //二分法改进版
        for (int i = 0; i < numbers.length; i++){
            int low = i + 1,high = numbers.length - 1;
            while (low <= high){
                int mid = (low + high)/2;
                if(numbers[i] + numbers[mid] == target){
                    return new int[]{i + 1,mid + 1};
                }else if (numbers[i] + numbers[mid] < target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return new int[]{-1,-1};
    }


}
