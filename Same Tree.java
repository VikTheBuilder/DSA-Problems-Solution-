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
