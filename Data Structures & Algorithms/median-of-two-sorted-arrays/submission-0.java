class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int index = 0;
        int start1 = 0;
        int start2 = 0;
        int ans = 0;
        int mid = len/2;
        int back = 0;
        while(index <= mid){
            back = ans;
            if(start1 < nums1.length && start2 < nums2.length){
                if(nums1[start1] < nums2[start2]){
                    ans = nums1[start1++];
                }else{
                    ans = nums2[start2++];
                }
            }else if(start1 < nums1.length){
                ans = nums1[start1++];
            }else{
                ans = nums2[start2++];
            }
            index++;
        }
        if(len%2 == 0){
            return (ans+back)/2.0;
        }else{
            return ans;
        }
    }
}
