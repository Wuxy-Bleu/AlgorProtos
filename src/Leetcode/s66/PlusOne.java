package Leetcode.s66;

/*给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。*/


import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        //这个题目如果没有进位的话，简单的过分.
        // 如果是进位的话，还需要考虑会不会长度+1
        // 这种题目感觉递归比较好啊。
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            int n = digits.length - 2;
            for (; n >= 0 && digits[n] == 9; n--) {
                digits[n] = 0;
            }
            if (n < 0) {
                int newArr[] = new int[digits.length + 1];
                newArr[0] = 1;
                return newArr;
            } else {
                digits[n]++;
                return digits;
            }

        }
    }

    //递归的话怎么做
    public static void plusOne(int[] digits, int n) {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
