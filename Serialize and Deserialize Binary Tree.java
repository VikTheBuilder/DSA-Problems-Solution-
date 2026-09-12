/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder();
        preorder(root, pre);
        return pre.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};
        return buildTree(values, index);
    }
    TreeNode buildTree(String[] values, int[] index){
        if (values[index[0]].equals("n")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(
            Integer.parseInt(values[index[0]])
        );
        index[0]++;
        root.left = buildTree(values, index);
        root.right = buildTree(values, index);
        return root;

    }
    void preorder(TreeNode root, StringBuilder data){
        if(root == null) {
            data.append("n,");
            return;
        }
        data.append(root.val).append(",");
        preorder(root.left, data);
        preorder(root.right, data);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
