package leet101_200;

import java.util.*;

public class leet112 {
    //二叉树路径总和判断
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        //广度优先搜索
        if (root == null)return false;
        Queue<TreeNode> q_node = new LinkedList<>();
        Queue<Integer> q_val = new LinkedList<>();
        q_node.add(root);
        q_val.add(root.val);
        while (!q_node.isEmpty()){
            TreeNode t = q_node.poll();
            int temp = q_val.poll();
            if (t.left == null && t.right == null){
                if (temp == sum)return true;
            }
            if (t.left != null){
                q_node.add(t.left);
                q_val.add(t.left.val + temp);
            }
            if (t.right != null){
                q_node.add(t.right);
                q_val.add(t.right.val + temp);
            }
        }
        return false;
    }
    public boolean hasPathSum_plus(TreeNode root, int sum) {
        //递归
        if (root == null) return false;
        if (root.right == null && root.left == null && root.val == sum){
            return true;
        }
        return hasPathSum_plus(root.left,sum - root.val) ||
                hasPathSum_plus(root.right,sum - root.val);
    }
}
