package Assignment4;

public class InOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode p = new TreeNode(1);
        var successor = new InOrderSuccessor();
        var result = successor.inorderSuccessor(root, p);
        System.out.println(result);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
