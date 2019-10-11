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
import java.util.List;

/**
 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 0 -> 8
 * ԭ��342 + 465 = 807
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
