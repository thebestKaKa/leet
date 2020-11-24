package leet101_200;

public class leet108 {
    //有序数组转化为二叉搜索树
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode solution(int[] nums,int left,int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = solution(nums,left,mid -1);
        ans.right = solution(nums,mid + 1,right);
        return ans;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return solution(nums,0,nums.length - 1);
    }
}
