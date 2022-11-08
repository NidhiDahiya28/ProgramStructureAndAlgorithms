package Assignment4;

public class ConvertBSTtoSortedDoublyList {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        var convert = new ConvertBSTtoSortedDoublyList();
        var result = convert.treeToDoublyList(root);
        System.out.println(result);
    }
    TreeNode lastNode = null;
    TreeNode head = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        inorder(root);
        if(lastNode!=null){
            lastNode.right = head;
            head.left = lastNode;
        }
        return head;
    }

    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(lastNode ==null){
            lastNode = root;
            head = lastNode ;
        }else{
            lastNode.right = root;
            root.left = lastNode;
            lastNode = lastNode.right;
        }
        inorder(root.right);
    }
}
