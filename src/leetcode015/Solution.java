package leetcode015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/3sum
 */

/**
 * ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
 * ����Ҫ�����Ԫ�鼯��Ϊ��
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (lists != null) {
                            for (List<Integer> integers : lists) {
                                boolean disjoint = Collections.disjoint(list, integers);
                                if (disjoint) {
                                    lists.add(list);
                                }
                            }
                        }else{
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}