class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int eachBucketNodes = size / k;   
        int remainderNodes = size % k;    

        ListNode[] result = new ListNode[k];
        curr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            result[i] = curr;
            
            int currentPartSize = eachBucketNodes + (remainderNodes > 0 ? 1 : 0);
            for (int count = 0; count < currentPartSize; count++) {
                prev = curr;
                if (curr != null) curr = curr.next;
            }
            
            if (prev != null) prev.next = null;  
            remainderNodes--;  
        }

        return result;
    }
}
