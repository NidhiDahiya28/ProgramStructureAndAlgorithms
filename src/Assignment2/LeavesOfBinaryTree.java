package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class LeavesOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        var res = LeavesOfBinaryTree.findLeaves(root);
        System.out.println(res);
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        findLeavesHelper(list, root);
        return list;
    }

    private static int findLeavesHelper(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(list, root.left);
        int rightLevel = findLeavesHelper(list, root.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        root.left = root.right = null;
        return level;
    }


}
