package leet1_100;

public class leet100 {
    //二叉树递归 深度优先搜索
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)return true;
        if (p == null && q != null)return false;
        if (p != null && q == null)return false;
        if (p.val != q.val)return false;
        else return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
