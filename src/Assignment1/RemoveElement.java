package Assignment1;

public class RemoveElement {public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(5);
    node.next.next.next.next = new ListNode(4);
    node.next.next.next.next.next = new ListNode(5);
    node.next.next.next.next.next.next = new ListNode(6);
    int val = 5;
    ListNode res = RemoveElement.removeElements(node,val);
    System.out.println(res.toString());
}

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode temp = head;
        if(head.data==val){
            while(temp!=null && temp.data==val){
                temp=temp.next;
            }
        }
        head=temp;
        while(temp!=null && temp.next!=null){
            if(temp.next.data==val){
                while(temp.next!=null && temp.next.data==val){
                    temp.next=temp.next.next;
                }
            }
            temp=temp.next;
        }
        return head;
    }




}
