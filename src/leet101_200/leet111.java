package leet101_200;

public class leet111 {
    //二叉树最小深度
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        int ans = 0;
        if (root == null)return 0;
        //叶子节点
        if (root.left == null && root.right == null)return 1;
        //非叶节点
        if (root.left != null && root.right == null) ans = minDepth(root.left);
        if (root.left == null && root.right != null) ans = minDepth(root.right);
        if (root.left != null && root.right != null)
            ans = Math.min(minDepth(root.left),minDepth(root.right));
        return ans + 1;
    }
    //官方题解，左边有就计算左边最小深度，右边有则计算右边，使用mip_depth进行比较
}
