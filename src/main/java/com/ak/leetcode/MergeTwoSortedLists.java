package com.ak.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {

    private List<Integer> ll1 = new ArrayList<>();
    private List<Integer> ll2 = new ArrayList<>();
    private List<Integer> ll3 = new ArrayList<>();

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        getList(ll1, list1);
        getList(ll2, list2);

        getMergedList(ll1, ll2, ll3);

        return getResultListNodeForLL(ll3);
    }

    private void getMergedList(List<Integer> ll1, List<Integer> ll2, List<Integer> ll3) {
        if (ll1.isEmpty() && !ll2.isEmpty()) {
            ll3.addAll(ll2);
        } else if (!ll1.isEmpty() && ll2.isEmpty()) {
            ll3.addAll(ll1);
        } else if (!ll1.isEmpty() && !ll2.isEmpty()) {
            if (ll1.get(0) <= ll2.get(0)) {
                ll3.add(ll1.get(0));
                ll1.remove(0);
                getMergedList(ll1, ll2, ll3);
            } else {
                ll3.add(ll2.get(0));
                ll2.remove(0);
                getMergedList(ll1, ll2, ll3);
            }
        }
    }

    private void getList(List<Integer> ll, ListNode ln) {
        if (ln != null) {
            ll.add(ln.val);
            if (ln.next != null) {
                getList(ll, ln.next);
            }
        }
    }

    private ListNode getResultListNodeForLL(List<Integer> ll) {
        ListNode r1 = new ListNode();
        if (ll.size() > 0) {
            r1.val = (int) ll.get(0);
            if (ll.size() > 1) {
                List<Integer> dL = (List<Integer>) ll.subList(1, ll.size());
                ListNode dLN = getResultListNodeForLL(dL);
                r1.next = dLN;
            }
        }
        return r1;
    }

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
