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
//Brute Force - First we are calculating the length then we are iterating and finding a before node and change it's reference of next to next.next
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int count = 0;
//         ListNode temp = head;
//         while(temp != null){
//             count++;
//             temp = temp.next;
//         }
//         if(count == n){
//             ListNode newHead = head.next;
//             return newHead;
//         }
//         int res = count - n;
//         temp = head;
//         while(temp != null){
//             res--;
//             if(res == 0){
//                 break;
//             }
//             temp = temp.next;
//         }
//         temp.next = temp.next.next;
//         return head;
//     }
// }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastp = head;
        ListNode slowp = head;
        for(int i=0;i<n;i++){
            fastp = fastp.next;
        }
        if(fastp == null){
            ListNode newHead = head.next;
            return newHead;
        }
        while(fastp.next != null){
            fastp = fastp.next;
            slowp = slowp.next;
        }
        slowp.next = slowp.next.next;
        return head;
    }
}