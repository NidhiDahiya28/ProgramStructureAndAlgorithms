package Assignment2;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        var res = VerticalOrderTraversal.verticalOrder(root);
        System.out.println(res);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Integer> qCol = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        qCol.offer(0);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = qCol.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>(Arrays.asList(curr.val)));
            } else {
                map.get(col).add(curr.val);
            }
            if(curr.left != null) {
                queue.offer(curr.left);
                qCol.offer(col - 1);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
                qCol.offer(col + 1);
            }
        }
        for(int n : map.keySet()) {
            res.add(map.get(n));
        }
        return res;
    }
}
