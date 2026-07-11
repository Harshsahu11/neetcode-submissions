class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int left = 0;
        int right = x;
    
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = (x + y + 1) / 2 - mid1;
            
            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = (mid1 == x) ? Integer.MAX_VALUE : nums1[mid1];
            
            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = (mid2 == y) ? Integer.MAX_VALUE : nums2[mid2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) +
                     Math.min(minRight1, minRight2)) / 2;
                } else {
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not valid or not sorted.");
    }
}