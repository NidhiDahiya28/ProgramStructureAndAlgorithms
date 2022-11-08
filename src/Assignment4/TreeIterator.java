package Assignment4;

import java.util.Stack;

public class TreeIterator {
    public static void main(String[] args) {

    }
    Stack<TreeNode> stack =  null ;
    TreeNode current = null ;
    public void BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<> ();
    }

    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left ;
        }
        TreeNode t = stack.pop() ;
        current = t.right ;
        return t.val ;
    }
}
