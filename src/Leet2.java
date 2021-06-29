import java.util.ArrayList;
import java.util.List;

public class Leet2 {
        public static void main(String[] args) {
            Leet2 l = new Leet2();
            /*System.out.println(l.addTwoNumbers(123));*/
            StringBuilder builder = new StringBuilder();
            //builder.length()
            builder.delete(0,0);
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = l1;
        ListNode second = l2;
        ListNode result = new ListNode();
        ListNode result_first = result;
        boolean add = false;
        while(first != null || second != null || add == true){
            if(first != null && second != null){
                result.val = first.val + second.val + (add ? 1 : 0);
                if(result.val >=10){
                    result.val -= 10;
                    add = true;
                }else{
                    add = false;
                }
                first = first.next;
                second = second.next;
                if(first == null && second == null && add == false){
                    break;
                }
                result.next = new ListNode();
                result = result.next;
            }else{
                result.val = (first != null? first.val : 0) + (second != null ? second.val : 0) + (add ? 1 : 0);
                add = false;
                if(result.val >=10){
                    result.val -= 10;
                    add = true;
                }else{
                    add = false;
                }
                if(first != null){
                    first = first.next;
                }
                if(second != null){
                    second = second.next;
                }
                if(first == null && second == null && add == false){
                    break;
                }
                result.next = new ListNode();
                result = result.next;

            }
        }
        return result_first;

    }
   /*     // 这个是想岔了，以为是正序存储的两个数字……还没做完
    public ListNode addTwoNumbers_error(ListNode l1, ListNode l2) {
        List<ListNode> n1 = new ArrayList<ListNode>();
        List<ListNode> n2 = new ArrayList<ListNode>();
        ListNode first = l1;
        ListNode second = l1;
        while(first.next != null){
            n1.add(first);
            first = first.next;
        }
        while(second.next != null){
            n1.add(second);
            second = second.next;
        }
    }*/

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
