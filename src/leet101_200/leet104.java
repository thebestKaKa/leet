package leet101_200;

import java.util.LinkedList;
import java.util.Queue;

public class leet104 {
    //二叉树最大深度
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        //深度优先搜索
        if (root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    public int maxDepth_2(TreeNode root) {
        //广度优先搜索
        if (root == null)return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0){
                TreeNode t = q.poll();
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}
