package leetcode.s88;

/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。*/

import java.util.Arrays;

//这个之前才刚实现过，不过需求有一些小的变化罢了。思路不变，实现方法需要变化
//它这个有序没有说是递增还是递减啊....
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArr = new int[m + n];

        for (int i = 0, index1 = 0, index2 = 0; i < mergedArr.length; i++) {
            if (index1 >= m) {
                mergedArr[i] = nums2[index2];
                index2++;
            } else if (index2 >= n) {
                mergedArr[i] = nums1[index1];
                index1++;
            } else {
                if (compare(nums1[index1], nums2[index2]) == -1) {
                    mergedArr[i] = nums1[index1];
                    index1++;
                } else {
                    mergedArr[i] = nums2[index2];
                    index2++;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mergedArr[i];
        }
    }

    private static int compare(int i, int j) {
        if (i < j)
            return -1;
        else if (i == j)
            return 0;
        else
            return 1;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};

        System.out.println(Arrays.toString(a));
    }
}
