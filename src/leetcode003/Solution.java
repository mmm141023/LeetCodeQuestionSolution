package leetcode003;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
 * ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
                i--;
            }else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "bbbbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}