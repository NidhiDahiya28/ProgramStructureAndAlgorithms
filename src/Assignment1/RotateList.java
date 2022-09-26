package Assignment1;

public class RotateList {public static void main(String[] args) {

    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    int val = 2;
    ListNode res = RotateList.rotateRight(node,val);
    System.out.println(res.toString());
}

    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        int i;
        for (i=0;fast.next!=null;i++)
            fast=fast.next;
        for(int j=0;j<i-k%i;j++)slow=slow.next;
        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;
        return dummy.next;
    }

}
