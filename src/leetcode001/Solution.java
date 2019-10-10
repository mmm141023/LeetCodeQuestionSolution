package leetcode001;

/**
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
 */

import java.util.HashMap;
import java.util.Map;

/**
 * ���� nums = [2, 7, 11, 15], target = 9
 * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 * ���Է��� [0, 1]
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * �ڶ�����ʱ�϶̵��㷨
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                result[0] = i;
                result[1] = hash.get(nums[i]);
                return result;
            }
            hash.put(target - nums[i], i);
        }
        return result;
    }

    /**
     * �������������
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + " === " + ints[1]);
    }
}

