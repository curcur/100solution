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
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
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


/**
 * - Inorder Traversal of BST is of sorted order
 *   - Use a prev pointer to record the prev node
 */
public class Solution {
    public TreeNode bst2DoubleLinkedList(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode curr = root, head = null, prev = null;
	
	while(curr!=null || !stack.isEmpty()) {
	    if(curr!=null) {
		stack.push(curr);
		curr = curr.left;
		continue;
	    }
	    curr = stack.pop();
	    if (head == null)  
		head = curr;
	    if (prev != null)
		prev.right = curr;
	    curr.left = prev;
	    prev = curr;
	    curr = curr.right;
	}
	return head;
    }
}
