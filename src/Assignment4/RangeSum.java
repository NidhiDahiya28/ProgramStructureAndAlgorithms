package Assignment4;

public class RangeSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        int low = 7;
        int high = 15;
        var range = new RangeSum();
        var result = range.rangeSumBST(root,low,high);
        System.out.println(result);
    }
    int lo,hi;
    int sum =0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        lo =low;
        hi=high;
        if(root==null)return 0;
        inorder(root);
        return sum;
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(root.val>=lo && root.val<=hi)sum +=root.val;
        inorder(root.right);
    }
}
