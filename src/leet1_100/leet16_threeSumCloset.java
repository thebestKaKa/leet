package leet1_100;

import java.util.Random;

public class leet16_threeSumCloset {
    //最接近的三数之和 时间复杂度N2logN 可以使用双指针优化到N2
    public static void shuffle(int[] nums){
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int cid = rand.nextInt(nums.length);
            exch(nums, i, cid);
        }
    }

    public static void sort(int[] nums){
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int low, int high){
        //快速排序
        if (low >= high)return;
        int k = partition(nums, low, high);
        sort(nums, low, k - 1);
        sort(nums, k + 1, high);
    }

    public static void exch(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static int partition(int[] nums, int low, int high){
        int i = low;
        int j = high + 1;
        int v = nums[low];
        while (true){
            while (nums[++i] < v) { if (i == high)break;}
            while (nums[--j] > v);
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, low, j);
        return j;
    }

    public static int bin_search(int[] nums, int low, int high, int target, int low_check, int high_check){
        //边界检查
        if (low > high) {
            if (low > high_check)return high;
            if (high < low_check)return low;
            int l = Math.abs(target - nums[low]);
            int h = Math.abs(target - nums[high]);
            return l < h ? low : high;
        }
        int mid = (high + low)/2;
        if (nums[mid] > target){
            return bin_search(nums, low, mid - 1, target, low_check, high_check);
        }else if (nums[mid] < target){
            return bin_search(nums, mid + 1, high, target, low_check, high_check);
        }else {
            return mid;
        }
    }

    public static int threeSumClosest(int[] nums, int target) {
        //返回最接近的三数之和
        if (nums.length < 3)return -1;
        int closet = nums[0] + nums[1] + nums[2];
        sort(nums);
        if (nums.length == 3)return nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int search = target - (nums[i] + nums[j]);
                int id = bin_search(nums, j + 1, nums.length - 1, search, j + 1, nums.length - 1);
                int temp = nums[i] + nums[j] + nums[id];
                if (Math.abs(target - temp) < Math.abs(target - closet)) closet = temp;
            }
        }
        return closet;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int[] nums1 = {1,1,-1,-1,3};
        int[] nums2 = {-1,0,1,1,55};
        System.out.println(threeSumClosest(nums1, -1));
    }
}
