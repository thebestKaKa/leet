package leet1_100;

public class leet_98_isValidBST {
    //验证二叉搜索树
    private long pre = Long.MIN_VALUE;
    private int flag = 0;

    private void dfs(TreeNode node){
        if (node == null)return;
        dfs(node.left);
        if (node.val <= pre){
            flag = 1;
            return;
        }
        pre = node.val;
        dfs(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag == 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
        }
    }
}
