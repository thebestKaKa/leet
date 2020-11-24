package leet501_600;

import java.util.Set;

public class leet530 {
    //二叉搜索树 寻找最小节点差
    public static int getMinimumDifference(TreeNode root) {
        TreeNode t = root;
        if (t.left == null && t.right == null)return Integer.MAX_VALUE;
        if (t.left == null){
            return Math.min(getMin(t.right) - t.val,getMinimumDifference(t.right));
        }
        if (t.right == null){
            return Math.min(t.val - getMax(t.left),getMinimumDifference(t.left));
        }
        int a = Math.min(getMinimumDifference(t.left),getMinimumDifference(t.right));
        int b = Math.min(t.val - getMax(t.left),getMin(t.right) - t.val);
        return Math.min(a,b);
    }

    public static int getMax(TreeNode root){
        TreeNode ans = root;
        while (ans.right != null)ans = ans.right;
        return ans.val;
    }

    public static int getMin(TreeNode root){
        TreeNode ans = root;
        while (ans.left != null)ans = ans.left;
        return ans.val;
    }

    static int pre;
    static int ans;
    public static int getMinimumDifference_2(TreeNode root) {
        //中序遍历
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    public static void dfs(TreeNode root){
        if (root == null)return;
        dfs(root.left);
        if (pre == -1)pre = root.val;
        else {
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode ar = new TreeNode(2236);
        TreeNode arr = new TreeNode(2776);
        TreeNode arl = new TreeNode(1277);
        TreeNode arll = new TreeNode(519);
        a.right = ar;
        ar.right = arr;
        ar.left = arl;
        arl.left = arll;
        System.out.println(getMinimumDifference_2(a));
    }
}
