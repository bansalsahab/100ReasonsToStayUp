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
    public int getDecimalValue(ListNode head) {
        StringBuilder sb  = new StringBuilder();
        ListNode temp = head;
        while(temp !=null){
            sb.append(temp.val);
            temp =temp.next;
        }
        int dec = Integer.parseInt(sb.toString() , 2);
        return dec;
    }
}
