package Assignment4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserialize {
    private static final String SEP = ",";
    private static final String NULL = "null";
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        var serial = new SerializeAndDeserialize();
        var res = serial.serialize(root);
        System.out.println(res.toString());
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return NULL;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null)  st.push(root.left);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }

    private TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        root.left = getNode(samllerQueue);
        root.right = getNode(q);
        return root;
    }
}
