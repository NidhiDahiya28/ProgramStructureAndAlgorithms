package Assignment1;

public class InsertIntoList {public static void main(String[] args) {
    ListNode node = new ListNode(3);
    ListNode temp = node;
    node.next = new ListNode(4);
    node.next.next = new ListNode(1);
    node.next.next.next = temp;
    int val = 2;
    var result = InsertIntoList.insert(node, val);
    var tempHead = result;
    System.out.print("[");
    do{
        System.out.print(result.data);
        if(result.next!=tempHead) System.out.print(",");
        result= result.next;
    }while(result!=tempHead);
    System.out.print("]");
}

    public static ListNode insert(ListNode head, int insertVal) {
        ListNode node=new ListNode(insertVal);
        if(head==null){
            node.next=node;
            return node;
        }
        ListNode cur = head;
        while(cur.next!=head){

            if(cur.data<=insertVal&&insertVal<=cur.next.data){
                break;
            }else if(cur.next.data<cur.data){
                if(insertVal<=cur.next.data||insertVal>=cur.data){
                    break;
                }
            }
            cur=cur.next;
        }
        ListNode nextNode = cur.next;
        cur.next=node;
        node.next=nextNode;
        return head;
    }
}
