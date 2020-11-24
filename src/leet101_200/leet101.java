package leet101_200;

import java.util.LinkedList;
import java.util.Queue;

public class leet101 {
    //对称二叉树
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean check(TreeNode p,TreeNode q){
        //递归
        if (p == null && q == null)return true;
        if (p == null || q == null)return false;
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
    public boolean check2(TreeNode p,TreeNode q){
        //迭代
        Queue<TreeNode> t = new LinkedList<>();
        t.add(p);
        t.add(q);
        while(!t.isEmpty()){
            p = t.poll();
            q = t.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            t.add(p.left);
            t.add(q.right);
            t.add(p.right);
            t.add(q.left);
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
}
