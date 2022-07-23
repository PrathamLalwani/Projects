class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        int total = nums1.length + nums2.length;
        int[] smaller = n < m ? nums1 : nums2;
        int[] bigger = n < m ? nums2 : nums1;

        double smallerLeft, smallerRight, biggerLeft, biggerRight;
        int l = 0;
        int r = smaller.length - 1;
        while (true) {
            i = (l + r) / 2;
            j = (total / 2) - i - 2;
            smallerLeft = i >= 0 ? smaller[i] : Double.NEGATIVE_INFINITY;
            smallerRight = i < smaller.length - 1 ? smaller[i + 1] : Double.POSITIVE_INFINITY;
            biggerLeft = j >= 0 ? bigger[j] : Double.NEGATIVE_INFINITY;
            biggerRight = j < bigger.length - 1 ? bigger[j + 1] : Double.POSITIVE_INFINITY;

            if (smallerLeft <= biggerRight && smallerRight >= biggerLeft) {
                if (total % 2 == 1) {
                    return Math.min(biggerRight, smallerRight);
                } else {
                    return (Math.max(biggerLeft, smallerLeft) + Math.min(biggerRight, smallerRight)) / 2;
                }

            } else if (smallerLeft < biggerRight) {
                r++;
            } else {
                l--;
            }

        }

    }

    public static void main(String[] args) {
        FindMedianSortedArrays x = new FindMedianSortedArrays();
        int[] nums1 = { 0, 0 };
        int[] nums2 = { 0, 0 };

        System.out.println(x.findMedianSortedArrays(nums1, nums2));
        ;

    }
}