/**
 * ----------------------------------------------------------------------------
   Convert BST to Sorted DoubleLinked List
    - Convert a Binary Search Tree to a sorted Double-linked List. 
    - We can only change the target of pointers, but cannot create any new nodes
 * ----------------------------------------------------------------------------
 */

/**
 * Related: 114 Flatten Binary Tree to Linked List
 * Tags: Binary Search Tree, Linked List
 */

/**
 * - Inorder Traversal of BST is of sorted order
 * - We can have the recursive function return two values:
 *   - The first node & last node given the root
 */

class TreeNodePair {
    TreeNode head, tail;
    TreeNodePair(TreeNode h, TreeNode t) {
	head = h; tail = t;
    }
}
public class Solution {
    public TreeNode bst2DoubleLinkedList(TreeNode root) {
	if (root == null)  return root;
	return bst2DLinkedList(root).head;
    }
    
    private TreeNodePair bst2DLinkedList(TreeNode root) {
	TreeNode head = null, tail = null;
	if (root.left == null)
	    head = root;
	else {
	    TreeNodePair leftp = bst2DLinkedList(root.left);
	    head = leftp.head;
	    leftp.tail.right = root;
	    root.left = leftp.tail;
	}

	if (root.right == null)
	    tail = root;
	else {
	    TreeNodePair rightp = bst2DLinkedList(root.right);
	    tail = rightp.tail;
	    rightp.head.left = root;
	    root.right = rightp.head;
	}
	return new TreeNodePair(head, tail);
    }
}
