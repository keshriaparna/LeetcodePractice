/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //Brute Force using hashing. T.C: O(N),S.C: O(N)
 class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(temp != null){
            if(map.containsKey(temp)){
            return true;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }
}
//Optimal using slow and fast pointer. T.C: O(N),S.C: O(1)
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast!= null && fast.next!= null){
//             slow = slow.next;
//             fast = fast.next.next;
//             if(slow == fast) return true;
//         }
//         return false;
//     }
// }