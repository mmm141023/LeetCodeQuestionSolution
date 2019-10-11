package leetcode004;

/**
 * 给定两个大小为 m 和 n 的有序数组?nums1 和?nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为?O(log(m + n))。
 * 你可以假设?nums1?和?nums2?不会同时为空。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
/**
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 */
/**
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */

/**
 *  index : 0  1  2  3   4   5
 *             L1 R1
 *  num1  : 3  5  8  9
 *  num2  : 1  2  7  10  11 12
 *                L2 R2
 *  1 2 3 5 7 | 8 9 10 11 12
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }
        if (nums1 != null || nums2 != null) {
            if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
                int l1 = nums1.length / 2 - 1;
                int r1 = nums1.length / 2;
                int l2 = nums2.length / 2 - 1;
                int r2 = nums2.length / 2;
                int left = 0;
                int right = 0;
                if (l1 <= r2 && l2 <= r1) {
                    left = Math.max(nums1[l1], nums2[l2]);
                    right = Math.min(nums1[r1], nums2[r2]);
                }
                while (l1 > r2 || l2 > r1) {
                    if (l1 > r2) {
                        l1 -= 1;
                        r1 -= 1;
                        l2 += 1;
                        r2 += 1;
                    }
                    if (l2 > r1) {
                        l1 += 1;
                        r1 += 1;
                        l2 -= 1;
                        r2 -= 1;
                    }
                }
                return (double) (left + right) / 2;
            } else if (nums1.length % 2 != 0 && nums2.length % 2 != 0) {
                int left = nums1.length / 2 + 1;
                int right = nums2.length / 2 + 1;
                return ((double) (nums1[left] + nums2[right])) / 2;
            } else if (nums1.length % 2 == 0 && nums2.length % 2 != 0) {
                int left1 = nums1.length / 2 - 1;
                int left2 = nums1.length / 2;
                double left = ((double)(nums1[left1] + nums1[left2])) / 2;
                int right = nums2.length / 2;
                return (left + nums2[right]) / 2;
            } else if (nums1.length % 2 != 0 && nums2.length % 2 == 0) {
                int left = nums1.length / 2;
                int right1 = nums2.length / 2 - 1;
                int right2 = nums2.length / 2;
                double right = ((double)(nums2[right1] + nums2[right2])) / 2;
                return (nums1[left] + right) / 2;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}