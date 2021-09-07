package leet101_200;

import algs4.In;

import java.util.HashMap;
import java.util.Map;

public class leet128_optiz {
    //并查集 最长连续序列 改
    public static class UF{
        private Map<Integer, Integer> leader;
        private int count;

        public UF(int[] nums){
            leader = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //用自身初始化
                leader.put(nums[i], nums[i]);
            }
            //数组有重复元素
            count = leader.size();
        }

        //找到leader
        public Integer find(int p){
            if (!leader.containsKey(p))return null;
            int idx = p;
            while (leader.get(p) != p) p = leader.get(p);
            //路径压缩
            while (leader.get(idx) != idx){
                int temp = leader.get(idx);
                leader.put(idx, p);
                idx = temp;
            }
            return p;
        }

        public void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot)return;
            // 小的连大的 q为更大的
            leader.put(pRoot, qRoot);
            count--;
        }
    }

    public static int longestConsecutive(int[] nums) {
        UF uf = new UF(nums);
        for (int i = 0; i < nums.length; i++) {
            if(uf.find(nums[i] + 1) != null){
                uf.union(nums[i], uf.find(nums[i] + 1));
            }
        }
        //找出最长序列
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, uf.find(nums[i]) - nums[i] + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
