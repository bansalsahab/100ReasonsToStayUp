/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1 != null){
            st1.push(l1.val);
            l1 =l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 =l2.next;
        }
        ListNode result = null;
        int carry =0 ;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0){
            int el1 = st1.isEmpty() ? 0 : st1.pop();
            int el2 = st2.isEmpty() ? 0 : st2.pop();
            int sum = el1 + el2 + carry;
            carry = sum / 10;           
            int digit = sum % 10;  
            ListNode newNode = new ListNode(digit);
            newNode.next = result;
            result = newNode;
        }
        return result;

    }
}
