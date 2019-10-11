package leetcode003;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
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