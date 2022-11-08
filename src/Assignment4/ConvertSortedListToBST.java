package Assignment4;

public class ConvertSortedListToBST {
    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);
        var sorted = new ConvertSortedListToBST();
        var result = sorted.sortedListToBST(node);
        System.out.println(result);
    }

    public  TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public  TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right= toBST(slow.next,tail);
        return thead;
    }
}
