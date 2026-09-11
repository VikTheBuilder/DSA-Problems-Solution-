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
 //avoiding overflow
 class Pair{
	TreeNode node;
	int index;
	Pair(TreeNode node, int index){
		this.node = node;
		this.index = index;
	}
}

class Solution{
	public int widthOfBinaryTree(TreeNode root){
		if(root == null) {
			return 0;
		}
		int width = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while(!q.isEmpty()) {
			int size = q.size();
			int prevIndex = q.peek().index;
			int first = 0;
            int last = 0;
			for(int i = 0; i<size; i++){
				int curr_id =  q.peek().index - prevIndex;  
                Pair temp = q.poll();
                if(i == 0){
                    first = curr_id;
                }
                if(i == size - 1){
                    last = curr_id;
                }
				if(temp.node.left != null){
					q.offer(new Pair(temp.node.left, 2 * curr_id + 1)); 
				}
				if(temp.node.right != null){
					q.offer(new Pair(temp.node.right, 2 * curr_id + 2));
				}
			}
			width = Math.max(width, last - first + 1);
		}
		return width;
	}
}
