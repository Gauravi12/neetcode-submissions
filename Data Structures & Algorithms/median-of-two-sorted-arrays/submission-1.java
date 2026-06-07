class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int start = 0;
        int end = m;

        int len = m + n;
        int left = (len + 1) / 2;

        while (start <= end) {

            int cut1 = (start + end) / 2;
            int cut2 = left - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (right1 < left2 || left1 > right2) {

                if (right1 < left2) {
                    start = cut1 + 1;
                } else {
                    end = cut1 - 1;
                }

            } else {

                if (len % 2 != 0) {
                    return Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) +
                            Math.min(right1, right2)) / 2.0;
                }
            }
        }

        return 0;
    }
}