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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class Solution {
    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 读取到第一个和第二个listNode的值
        while (l1.next != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        list1.add(l1.val);
        while (l2.next != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        list2.add(l2.val);
        String val1 = "";
        String val2 = "";
        for (int i = list1.size() - 1; i >= 0; i--) {
            val1 += list1.get(i);
        }
        for (int j = list2.size() - 1; j >= 0; j--) {
            val2 += list2.get(j);
        }
        int val11 = Integer.parseInt(val1);
        int val12 = Integer.parseInt(val2);
        int sumNum = val11 + val12;
        String sumString = String.valueOf(sumNum); //807
        Map<Integer, listNode> map = new HashMap<>();
        for (int i = sumString.length() - 1; i >= 0 ; i--) {
            char c = sumString.charAt(i);
            int numericValue = Character.getNumericValue(c);
            listNode listNode = new listNode(numericValue);
            int val = listNode.val;
            map.put(i, listNode);
        }
        for (int i = sumString.length() - 1; i > 0 ; i--) {
            map.get(i).next = map.get(i - 1);
        }
        map.get(0).next = null;
       return map.get(sumString.length() - 1);
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
