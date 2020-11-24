package leet101_200;

public class leet110 {
    //判断是否是平衡二叉树
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int high(TreeNode root){
        int ans = 0;
        if(root == null) return 0;
        ans = Math.max(high(root.left),high(root.right)) + 1;
        return ans;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        return isBalanced(root.left) && isBalanced(root.right) &&
                Math.abs(high(root.left) - high(root.right)) <= 1;
    }
}
