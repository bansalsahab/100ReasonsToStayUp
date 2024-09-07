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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set =new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }  
        int count =0 ;
        ListNode temp1 =head;

        while(temp1!=null){
            if(set.contains(temp1.val)){
               
                if(temp1.next == null){
                    count++;
                }
                else if(!set.contains(temp1.next.val)){
                    count++;
                }
            }
            temp1 = temp1.next;
            
        }
        return count;
    }
}
