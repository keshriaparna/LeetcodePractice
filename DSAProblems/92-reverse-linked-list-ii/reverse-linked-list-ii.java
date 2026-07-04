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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right){
            return head;
        }
        ListNode dummyNode = new ListNode(0,head);
        ListNode beforeReverse = dummyNode;
        for(int i = 0;i < left - 1; i++){
            beforeReverse = beforeReverse.next;
        }

        //ListNode nodeJustBeforeReverse = beforeReverse;
        ListNode firstNodeToReverse = beforeReverse.next;

        ListNode previous = beforeReverse;
        ListNode current = firstNodeToReverse;
        for(int i=0;i<right-left+1;i++){
            ListNode nextNode = current.next;
            current.next = previous;

            previous = current;
            current = nextNode;
        }
        
        beforeReverse.next = previous;
        firstNodeToReverse.next = current;

        return dummyNode.next;
    }
}