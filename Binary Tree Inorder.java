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
// Traversal--
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
//Morris Traversal--
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        var curr = root;
        while (curr != null){
            if (curr.left == null){
                res.add(curr.val);
                curr = curr.right; 
            } else { 
                var pre = curr.left;
                while (pre.right != null){ 
                    pre = pre.right;
                }
                pre.right = curr;
                var temp = curr; 
                curr = curr.left; 
                temp.left = null;
            }
        }
        return res;
    }
}
