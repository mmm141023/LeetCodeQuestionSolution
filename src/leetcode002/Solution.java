package leetcode002;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * 给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0?开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class Solution {
    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        listNode listNode = new listNode(0);
        int sum = 0;
        listNode curr = listNode;
        listNode p1 = l1, p2 = l2;
        while (p1 != null || p2 !=null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            curr.next = new listNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }
        if (sum == 1) {
            curr.next = new listNode(sum);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
//        构造输入listNode
        listNode l11 = new listNode(2);
        listNode l12 = new listNode(4);
        listNode l13 = new listNode(3);
        l11.next = l12;
        l12.next = l13;
        listNode l21 = new listNode(5);
        listNode l22 = new listNode(6);
        listNode l23 = new listNode(4);
        l21.next = l22;
        l22.next = l23;
        listNode listNode = addTwoNumbers(l11, l21);
        List<Integer> list = new ArrayList<>();
        while (listNode.next != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        list.add(listNode.val);

        String result = "";
        for (Integer integer : list) {
            result += integer + "->";
        }
        System.out.println(result);
    }
}

class listNode {
    int val;
    listNode next;
    listNode(int x) {
        val = x;
    }
}
