package Assignment1;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodes {public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    int val = 2;
    ListNode res = SwappingNodes.swapNodes(node,val);
    System.out.println(res.toString());
}


    public static ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        ListNode left = list.get(k-1);
        ListNode right = list.get(list.size()-k);
        swap(left,right);
        return head;
    }

    public static void swap(ListNode left, ListNode right){
        int temp=left.data;
        left.data=right.data;
        right.data=temp;
    }
}
