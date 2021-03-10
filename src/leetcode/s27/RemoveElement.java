package leetcode.s27;

/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。*/

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        //第一个想到的就是遍历嘛，然后遇到元素==val的移到 数组的末尾
        int n = nums.length - 1;  /*存放移除后数组的长度，每次发现一个val就-1,同时n作为数组交换时的索引*/
        for (int i = 0; i < nums.length && i < n; i++) {
            //这里再第一次开发的时候忽略了两个问题 这两个低级错误应该在一开始就想到
            //1. 前后两个指针，再重合的时候不应该在继续遍历了
            //2. 前后交换的时候 注意后面那个指针对应的元素不能是val啊
            if (nums[i] == val)
//                if (nums[n] == val) {  /*如果后面的那个数正好也是val的话*/
//                    nums[i] = nums[--n]; //这里还是不行啊，如果--n还是val怎么办 没考虑到啊 还有如果--的过程中和前指针i重合了怎么办
//                                         //这里的逻辑需要重写，
////                    nums[n] = val;  //等等 根据他的题目，我不需要完全替换啊，只要替换一半就够了啊
//                    n--;
                while (n > i) {
                    if (nums[n] == val)
                        n--;
                    else {
                        nums[i] = nums[n];
                        n--;
                        break;
                    }
                }
//            else {
//                nums[i] = nums[n];
//                n--;
//            }
        }
        if (nums.length == 0)
            return 0;
        else if (nums[n] != val)
            return n + 1;
        else
            return n;
    }

//这个题目的解答 经历了三个阶段  todo 必须学会将自己的思维过程用流程图或者表达式写出来
//这个问题的难点就在于，前后两个 指针的重合问题，
    // 1. 用循环遍历
    // 2.后指针也为val
    //  3. 重合问题
    // 4. 重合点的位置
    // 5. 比较特殊的数组 空数组之类的  全val数组

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 3, 1, 1, 1, 1
        };
        int i = removeElement(arr, 1);
        System.out.println(i + " " + Arrays.toString(arr));
    }
}

