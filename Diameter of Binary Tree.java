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
//ARRAY Approach:-
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        maxDepth(root, max);
        return max[0];
    }
    public int maxDepth(TreeNode root, int[] max) {
        if (root == null) return 0;
        int lh = maxDepth(root.left, max);
        int rh = maxDepth(root.right, max);
        max[0] = Math.max(max[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}

//Global Variable Approach:-
class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;        
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, l + r);
        return 1 + Math.max(l, r);
    }    
}
