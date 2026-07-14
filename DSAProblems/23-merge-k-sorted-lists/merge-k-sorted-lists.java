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
// class Solution {
//     private ListNode convertArrayListToLinkedList(ArrayList<Integer> arr){
//         ListNode dummyNode = new ListNode(-1,null);
//         ListNode temp = dummyNode;
//         for(int i=0;i<arr.size();i++){
//             temp.next = new ListNode(arr.get(i),null);
//             temp = temp.next;
//         }
//         return dummyNode.next;
//     }
//     public ListNode mergeKLists(ListNode[] lists) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         for(int i=0;i<lists.length;i++){
//             ListNode temp = lists[i];
//             while(temp != null){
//                 ans.add(temp.val);
//                 temp = temp.next;
//             }
//         }
//         Collections.sort(ans);
//         return convertArrayListToLinkedList(ans);
//     }
// }
class Solution {
    private ListNode mergeTwoSortedLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1,null);
        ListNode temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        }
        else{
            temp.next = list2;
        }
        return dummyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode head = lists[0];
        for(int i=1;i<lists.length;i++){
            head = mergeTwoSortedLists(head,lists[i]);
        }
        return head;
    }
}