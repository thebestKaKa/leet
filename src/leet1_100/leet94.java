package leet1_100;

import java.util.*;

public class leet94 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null)return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {
        //注意栈和队列的区别！！
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()){//边界处理
            while (root!=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
