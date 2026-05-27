/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int l1 = 0;
        int l2 = 0;
        while(tempA!=null){
            l1++;
            tempA = tempA.next;
        }
        while(tempB!=null){
            l2++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        if(l1>l2){
            for(int i=1;i<=l1-l2;i++){
                tempA = tempA.next;
            }
        }else{
            for(int i=1;i<=l2-l1;i++){
                tempB = tempB.next;
            }
        }

        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}