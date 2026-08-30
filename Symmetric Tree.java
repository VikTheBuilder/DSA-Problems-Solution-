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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root != null? helper(root.left, root.right) : true;
    }
    boolean helper(TreeNode root1, TreeNode root2){
        if(root1==null && root2 == null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val != root2.val)return false;
        if (root1.left != null && root2.right != null) {
            if (!helper(root1.left, root2.right))
                return false;
        } 
        else if (root1.left != null || root2.right != null) {
            return false;
        }
        if (root1.right != null && root2.left != null) {
            if (!helper(root1.right, root2.left))
                return false;
        } 
        else if (root1.right != null || root2.left != null) {
            return false;
        }
        return true; 
    }
}
