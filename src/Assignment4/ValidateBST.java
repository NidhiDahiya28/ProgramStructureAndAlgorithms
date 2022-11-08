package Assignment4;

public class ValidateBST { public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    var validate = new ValidateBST();
    var res = validate.isValidBST(root);
    System.out.println(res);
}
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root==null)return true;
        if(root.val<=min || root.val>=max)return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
