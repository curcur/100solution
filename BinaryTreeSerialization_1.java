/**
 * ----------------------------------------------------------------------------
   Binary Tree Serialization (lintcode)
    - Design an algorithm and write code to serialize and deserialize a binary 
      tree
    - Writing the tree to￼a file is called ``serialization''
    - Reading back from the file to reconstruct the exact same binary tree is 
      ``deserialization''
 * ----------------------------------------------------------------------------
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

/**
 * Preorder DFS Serialization
 * The problem of BFS is that when the tree is unbalanced, we need to store
 * quite a lot of nulls in each level
 */

class Solution {
   
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return; // XXXX miss this first time
        }
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    public TreeNode deserialize(String data) {
        // write your code here
        StringBuilder sb = new StringBuilder(data);
        return deserialize(sb);
    }
    
    private TreeNode deserialize(StringBuilder sb) {
        int index = sb.indexOf(",");
        String sub = sb.substring(0, index);
        sb.delete(0, index+1);
        
        if (sub.equals("#"))
            return null;
            
        TreeNode root = new TreeNode(Integer.valueOf(sub));
        root.left = deserialize(sb);
        root.right = deserialize(sb);
        
        return root;
    }
}

