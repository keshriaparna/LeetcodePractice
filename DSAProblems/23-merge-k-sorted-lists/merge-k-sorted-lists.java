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
    private ListNode convertArrayListToLinkedList(ArrayList<Integer> arr){
        ListNode dummyNode = new ListNode(-1,null);
        ListNode temp = dummyNode;
        for(int i=0;i<arr.size();i++){
            temp.next = new ListNode(arr.get(i),null);
            temp = temp.next;
        }
        return dummyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp != null){
                ans.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(ans);
        return convertArrayListToLinkedList(ans);
    }
}