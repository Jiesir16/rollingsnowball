package net.itajay.rollingsnowball.daily.question;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

import java.util.LinkedList;
import java.util.List;

/**
 * 2023-02-27
 * https://leetcode.cn/problems/add-two-numbers/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        addTwoNumbers(l1, l2);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个预先头指针，用来返回结果
        ListNode prev = new ListNode(0);
        // 进位值
        int carry = 0;
        // 定义个游标
        ListNode cur = prev;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;

            // 是否进位
            carry = sum / 10;
            // 当前节点要赋予的值
            int nodeVal = sum % 10;
            cur.next = new ListNode(nodeVal);
            // 移动游标
            cur = cur.next;
            // 将两个链表指针后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 跳出循环后发现进位还有值
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        List<Integer> ints = new LinkedList<>();
        while (prev.next != null) {
            prev = prev.next;
            ints.add(prev.val);
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(ints));
    }

}
