package Leetcode.s456;
//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
//
//        如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。

public class Find132Pattern {

    public static boolean find132pattern(int[] nums) {

        boolean exist = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j])
                        exist = true;
                }
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 2, 5, 6, 7}));
    }

}
