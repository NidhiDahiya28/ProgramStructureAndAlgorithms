package Quiz1;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "Node=" + val ;
    }
}
