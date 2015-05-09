/**
 * ----------------------------------------------------------------------------
   Closest Node in a Binary Search Tree
    - Given a binary search tree and a value k
    - please find a node in the binary search tree whose value is closest to k
 * ----------------------------------------------------------------------------
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * - if val > root.val, the closest node can only in the right subtree
 * - if val < root.val, the closest node can only in the left subtree
 * - else it is just root
 * - similar to Binary Search Tree Search's variation
 */

// 1. Iterative

public class Solution {
    public TreeNode closestNode(TreeNode root, int val) {
	TreeNode cl_node = root, curr = root;
	
	while(curr != null) {
	    if (Math.abs(cl_node.val-val) > Math.abs(curr.val-val))
		cl_node = curr;
	    if (curr.val == val)
		break;
	    else if (curr.val > val)
		curr = curr.left;
	    else 
		curr = curr.right;
	}
	return cl_node;
    }
}


// -----------------------------------------------------------------------------

// 2. Recursive 

/**
 * Here are ways to show correct and wrong Recursion:
 * - If we wanna some recursive function to return some value, 
 *   we can not put it as a parameter
 * - A parameter can be changed its internal value, like path.add(node) 
 *   but it can not be assigned, like path = path1;
 *   because after rolling back to previous recursion stack,
 *   the parameter will be recovered to point to its previous object
 * - The following are three ways to show correct & wrong recursion
 */

// Recursive 2.1 -- use global object

public class Solution {
    TreeNode cl_node;
    public TreeNode closestNode(TreeNode root, int val) {
	cl_node = root;
	closest(root, val);
	return cl_node;
    }

    private void closest(TreeNode root, int val) {
	if (root == null)  return;

	if (Math.abs(cl_node.val-val) > Math.abs(root.val-val))
		cl_node = root;

	if (root.val > val) 
	    closest(root.left, val);
	else if (root.val < val)
	    closest(root.right, val);
    }
}


// Recursive 2.2 -- use return value

public class Solution {
    public TreeNode closestNode(TreeNode root, int val) {
	return closest(root, val, root);
    }

    private TreeNode closest(TreeNode root, int val, TreeNode cl_node) {
	if (root == null)  return cl_node;
	
	if (Math.abs(cl_node.val-val) > Math.abs(root.val-val))
	    cl_node = root;
	
	if (root.val > val) 
	    return closest(root.left, val, cl_node);
	else if (root.val < val)
	    return closest(root.right, val, cl_node);
	else 
	    return cl_node;
    }
}


// XXXX Recursive wrong -- use assignment is wrong

public class Solution {
    public TreeNode closestNode(TreeNode root, int val) {
	TreeNode cl_node = root;
	closest(root, val, cl_node);
	return cl_node;
    }

    private void closest(TreeNode root, int val, TreeNode cl_node) {
	if (root == null)  return;

	if (Math.abs(cl_node.val-val) > Math.abs(root.val-val))
		cl_node = root;

	if (root.val > val) 
	    closest(root.left, val, cl_node);
	else if (root.val < val)
	    closest(root.right, val, cl_node);
    }
}
