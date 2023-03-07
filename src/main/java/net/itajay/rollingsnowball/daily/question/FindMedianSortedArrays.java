package net.itajay.rollingsnowball.daily.question;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,10,55,98,168,198,900};
        int[] nums2 = new int[]{1,5,11,22,25,68,70,99,201,300};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    /**
     * TODO 时间复杂度是O((m+n)/2),非O(log (m+n))
     *
     * 思路1 归并排序，因为两个大小分别为 m 和 n 的正序（从小到大）数组，所以将两个数组从第零个元素开始依次比较合并
     *  m+n是奇数的话，新数组的第(m+n)/2+1个数，该位置的数即中位数
     *  m+n是偶数的话，新数组的(m+n)/2和(m+n)/2+1这两个数据和除以2即两个数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // num1数组的长度
        int m = nums1.length;
        // num2数组的长度
        int n = nums2.length;
        // 新数组num3的长度
        int count = m + n;
        // 判断是偶数还是奇数
        boolean flag = false;
        if (count % 2 ==0) {
            flag = true;
        }
        int[] nums3 = new int[count];


        // num1下标
        int i = 0;
        // num2下标
        int j = 0;
        // num3下标
        int cur = 0;
        int k = count / 2;
        while(cur <= k) {
            // 边界情况，当num1或num2的指针到达数组的末位时，依次将另一个数组填充到新数组中
            if (i == m) {
                nums3[cur++] = nums1[j++];
                continue;
            }
            if (j == n) {
                nums3[cur++] = nums2[i++];
                continue;
            }
            // 比较值
            if (nums1[i] <= nums2[j]) {
                nums3[cur++] = nums1[i++];
            } else {
                nums3[cur++] = nums2[j++];
            }
        }

        return flag ? (nums3[k]+nums3[k-1])/2.0 : nums3[k];
    }
}
