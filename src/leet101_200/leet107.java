package leet101_200;

import javax.sound.sampled.EnumControl;
import java.util.*;

public class leet107 {
    //二叉树自底向上层次遍历
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            while(size > 0){
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
                size--;
            }
            ans.add(0,list);
        }
        return ans;
    }
}
