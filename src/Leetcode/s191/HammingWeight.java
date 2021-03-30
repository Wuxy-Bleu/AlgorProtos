package Leetcode.s191;

//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

//这个题的关键就是在于int的范围 -2^31——2^31-1
//那么如何标识  1后面31的0的数字呢 -1？

public class HammingWeight {
    public static int hammingWeight(int n) {

        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (i == 0 && n < 0)
                num++;
            if (i != 0 && (n & (int) Math.pow(2, (31 - i))) != 0)
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        hammingWeight(5);
    }


}
