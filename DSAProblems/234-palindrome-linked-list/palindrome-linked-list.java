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
 // Brute Force - using stack to get the Linkedlist valuse in reverse and then compare by iterating on original Linked List T.C:O(N) , S.C: O(N)
//  class Solution {
//     public boolean isPalindrome(ListNode head) {
//         Stack<Integer> st = new Stack<>();
//         ListNode temp = head;
//         while(temp != null){
//             st.push(temp.val);
//             temp = temp.next;
//         }
//         temp = head;
//         while(temp != null){
//             if(temp.val != st.pop()){
//                 return false;
//             }
//             temp = temp.next;
//         }
//         return true;
//     }
// }

 //optimal - T.C: O(N) , S.C: O(1)
class Solution {
        private ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode currp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currp1;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null) return true;
      ListNode slow = head;
      ListNode fast = head;
      while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }
      ListNode newHead = reverseLinkedList(slow.next);
      ListNode first = head;
      ListNode second = newHead;
      while(second != null){
        if(first.val != second.val){
            reverseLinkedList(newHead);
            return false;
        }
        first = first.next;
        second = second.next;
      }
      reverseLinkedList(newHead);
      return true;
    }
}