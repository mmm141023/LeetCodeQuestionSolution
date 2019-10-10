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
 * ��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * �����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 0 -> 8
 * ԭ��342 + 465 = 807
 */
class Solution {
    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // ��ȡ����һ���͵ڶ���listNode��ֵ
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
//        ��������listNode
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
