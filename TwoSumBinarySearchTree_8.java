/**
 * ----------------------------------------------------------------------------
   Two Node Sum in a Binary Search Tree
    - Given a binary search tree, please check whether there are two nodes 
      in it whose sum equals a given value.
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
 * - This is similar to Two Sum, of course
 * - if we search the node match for every node, we need O(nlogn) time
 * - But there are two pointers solution for two sum, we can do it similary
 *
 * - Inorder Traversal of BST tree is in sorted order
 */

public class Solution {
    public boolean twoSum(TreeNode root, int val) {
	if (root == null)  return false;

	Stack<TreeNode> nextStack = new Stack<>();
	Stack<TreeNode> prevStack = new Stack<>();
	TreeNode left = getNext(root, nextStack);
	TreeNode right = getPrev(root, prevStack);

	while(left != right) {
	    int curval = left.val + right.val;
	    if (curval == val)
		return true;
	    else if (curval < val) 
		left = getNext(left.right, nextStack);
	    else
		right = getPrev(right.left, prevStack);
	}
	// XXXX
	return false;
    }

    private TreeNode getNext(TreeNode curr, Stack<TreeNode> nextStack) {
	while(curr!=null || !nextStack.isEmpty()) {
	    if(curr!=null) {
		nextStack.push(curr);
		curr = curr.left;
		continue;
	    }
	    curr = nextStack.pop();
	    return curr;
	}
	return null;
    }

    private TreeNode getPrev(TreeNode curr, Stack<TreeNode> prevStack) {
	while(curr!=null || !prevStack.isEmpty()) {
	    if (curr!=null) {
		prevStack.push(curr);
		curr = curr.right;
		continue;
	    }
	    curr = prevStack.pop();
	    return curr;
	}
	return null;
    }

}
