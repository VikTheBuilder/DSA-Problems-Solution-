/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Serialize Tree using Preorder Traversal Approach-
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> result1 = new ArrayList<>();
        helper(p, result1);
        List<Integer> result2 = new ArrayList<>();
        helper(q, result2);
        return (result1.equals(result2));
    }
    void helper(TreeNode root, List<Integer> list){
        if(root == null){
            list.add(null);
            return;
        } 
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}

//Recursive Tree Comparison Approach-
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
    boolean helper(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return helper(p.left, q.left) && helper(p.right, q.right);
    }
}
