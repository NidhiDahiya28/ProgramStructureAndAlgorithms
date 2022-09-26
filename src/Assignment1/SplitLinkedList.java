package Assignment1;

public class SplitLinkedList {public static void main(String[] args) {
    ListNode node = new ListNode (1);
    node.next = new ListNode (2);
    node.next.next = new ListNode (3);
    int val = 5;
    ListNode [] result = SplitLinkedList.splitListToParts(node,val);
    print(result);
}

    public static ListNode [] splitListToParts(ListNode root, int k) {
        ListNode  cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;
        ListNode [] ans = new ListNode [k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode  head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
    public static void print(ListNode  [] result){
        for(int i =0;i < result.length;i++){
            if(result[i]!=null){
                System.out.print("["+ result[i].data+"]");
            }else{
                System.out.print("[]");
            }
            if(i!=result.length-1) System.out.print(",");
        }
    }
}
