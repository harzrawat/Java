package com.DSA.ClassLab;

import java.util.HashMap;
import java.util.Map;

public class LoopLinkedList {
    public boolean hasCycle(ListNode head) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(head.val, true);
        while (head.next != null){
            if (map.get(head.next.val)){
                return true;
            }
            map.put(head.next.val, true);
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
