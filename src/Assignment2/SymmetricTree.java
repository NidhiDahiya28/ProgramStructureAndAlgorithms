package Assignment2;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        var res = SymmetricTree.isSymmetric(root);
        System.out.println(res);
    }

    public static boolean isSymmetric(TreeNode root) {

        return root == null || isSame(root.left,root.right);
    }
    private static boolean isSame(TreeNode left,TreeNode right){
        if (left == null && right == null)
            return true;
        if (left != null && right != null){
            return left.val == right.val && isSame(left.left, right.right) && isSame(left.right,right.left);
        }
        return false;
    }
}
