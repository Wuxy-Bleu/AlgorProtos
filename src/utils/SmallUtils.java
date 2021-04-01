package utils;

import java.util.Arrays;
import java.util.Random;

public class SmallUtils {

    //得到一个int正整数的位数
    public static int numOfDigits(int n) {
        //todo 这里比较麻烦的是去判断传入的数字在int的正整数范围内
        int nums = 0;
        for (int i = n; i / 10 != 0; i /= 10)
            nums++;
        return nums + 1; /*再加一个个数位*/
    }

    //根据字节将一个Int转为4个byte  熟悉位运算
    public static byte[] int2byteArr(int n) {
        byte[] res = new byte[4];
        res[0] = (byte) (n >> 24);
        res[1] = (byte) (n >> 16);
        res[2] = (byte) (n >> 8);
        res[3] = (byte) (n >> 0);

        return res;
    }

    //生成一个随机数组，未排序
    public static int[] generateRandomArr(int len) {
        int[] res = new int[len];
        Random random = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }

    public static void main(String[] args) {
        int2byteArr(-1);
        int[] ints = generateRandomArr(20);
        System.out.println(Arrays.toString(ints));

    }

}
