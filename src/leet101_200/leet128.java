package leet101_200;

import java.util.Arrays;

public class leet128{
    //最长连续数列 并查集 q
    // quick find
    public static int find(int p, int[] idx){
        return idx[p];
    }

    public static void union(int p, int q, int[] idx){
        int pId = find(p, idx);
        int qId = find(q, idx);
        if (pId == qId)return;
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] == qId) idx[i] = pId;
        }

    }

    public static int longestConsecutive(int[] nums) {
        int[] idx = new int[nums.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == 1){
                    union(i, j, idx);
                }
            }
        }

        Arrays.sort(idx);
        int count = 1;
        int max = 0;
        for (int i = 0; i < idx.length - 1; i++) {
            if (idx[i + 1] == idx[i]) count++;
            else {
                if (count > max) max = count;
                count = 1;
            }
        }
        if (count > max) max = count;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums2));
    }
}
