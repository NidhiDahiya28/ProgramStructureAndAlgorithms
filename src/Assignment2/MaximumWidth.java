package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        var res = MaximumWidth.width(root);
        System.out.println(res);
    }

    public static int width(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }


}
