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
// Traversal Approach 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int N = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<N; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val); 
            }
            ans.add(subList);
        }  
        for(int j=0; j<ans.size(); j++){
            if(j%2==1) Collections.reverse(ans.get(j));
        }
        return ans;
    }
}
